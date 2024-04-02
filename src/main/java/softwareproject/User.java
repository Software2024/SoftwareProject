package softwareproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class User {
private int ssn;
private static User instance;
public User() {
	ssn = -1;
}

public static User getInstance() {
    if (instance == null) {
        instance = new User();
    }
    return instance;
}
public void setSSN(int ssn) {
    instance.ssn = ssn;
}
public int getSSN() {
    return instance.ssn;
}

boolean isValidEmail(String email) {
    final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pattern = Pattern.compile(EMAIL_REGEX);
    if (!pattern.matcher(email).matches()) {
        JOptionPane.showMessageDialog(null, "The email address is not valid.");
        return false;
    }
    return true;
}

boolean isPasswordLongEnough(String password) {
    boolean isLongEnough = password.length() >= 8;
    if (!isLongEnough) {
        JOptionPane.showMessageDialog(null, "The password should be 8 characters or more.");
    }
    return isLongEnough;
}

public boolean signUp(int ssn, String firstName, String lastName, String email, String password, int phoneNumber) {
    if (isValidEmail(email) && isPasswordLongEnough(password)) {
        if (!isEmailAlreadyRegistered(email,"dream.user")) {
            String query = "INSERT INTO dream.user (ssn, \"first name\", \"last name\", \"email\", \"password\",\"phone number\") VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection con = DataBasecon.getConnection();
                 PreparedStatement q = con.prepareStatement(query)) {
                q.setInt(1, ssn);
                q.setString(2, firstName);
                q.setString(3, lastName);
                q.setString(4, email);
                q.setString(5, password);
                q.setInt(6, phoneNumber);
                q.executeUpdate();
                getInstance();
                setSSN(ssn);
                JOptionPane.showMessageDialog(null, "Welcome.");
               return true;
            } catch (SQLException e) {
            	Event.displayErrorMessage();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email already has an account. Please use a different email.");
        }
    }return false;
}


public boolean logIn(String email, String password,String tableName) {
	 if (isEmailAlreadyRegistered(email,tableName)) {
	        try (Connection con = DataBasecon.getConnection();
	             PreparedStatement q = con.prepareStatement("SELECT password,ssn FROM " + tableName + " WHERE email = ?")) {
	            q.setString(1, email);
	            try (ResultSet rs = q.executeQuery()) {
	                if (rs.next()) {
	                    String storedPassword = rs.getString("password");
	                    if (password.equals(storedPassword)) {
	                    	int SSN =rs.getInt("ssn");
	                    	  getInstance();
	                    	setSSN(SSN);

	                        JOptionPane.showMessageDialog(null, "Welcome.");
	                        return true;
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Email not registered. Please sign up.");
	                }
	            }
	        } catch (SQLException e) {
	        	Event.displayErrorMessage();
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Email not registered. Please sign up.");
	    }
	    return false;
	}

	public boolean isEmailAlreadyRegistered(String email, String tableName) {
	    String query = "SELECT 1 FROM " + tableName + " WHERE email = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, email);
	        try (ResultSet rs = stmt.executeQuery()) {
	            return rs.next(); 
	        }
	    } catch (SQLException e) {
	        return false;
	    }
	}
	public List<Object[]> retrieveEvents(int ssn, boolean isAdmin) {
	    List<Object[]> eventData = new ArrayList<>();

	    String query;
	    if (isAdmin) {
	        query = "SELECT * FROM dream.event";
	    } else {
	        query = "SELECT * FROM dream.event WHERE \"creater id\" = ?";
	    }

	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {

	        if (!isAdmin) {
	            stmt.setInt(1, ssn);
	        }

	        try (ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Object[] rowData = {
	                    rs.getInt("number"),
	                    rs.getString("bride full name"),
	                    rs.getString("groom full name"),        
	                    rs.getDate("date"),
	                    rs.getInt("total cost"),
	                    rs.getInt("budget"),
	                    rs.getString("theme"),
	                    rs.getString("city_location"),
	                    rs.getInt("guest count")
	                };
	                eventData.add(rowData);
	            }
	        }
	    } catch (SQLException ex) {
	    	Event.displayErrorMessage();
	    }
	    
	    return eventData;
	}

	public void populateTableModel(DefaultTableModel model, List<Object[]> eventData) {
	    model.setRowCount(0); 

	    for (Object[] rowData : eventData) {
	        model.addRow(rowData);
	    }

	    model.fireTableDataChanged();
	}
	public boolean isAdmin(int ssn) {
	    boolean isAdmin = false;
	    String query = "SELECT COUNT(*) FROM dream.admin WHERE ssn = ?";
	    
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setInt(1, ssn);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                isAdmin = count > 0;
	            }
	        }
	    } catch (SQLException ex) {
	    	Event.displayErrorMessage();
	    }
	    
	    return isAdmin;
	}
	  public boolean removeUser(int ssn) throws SQLException {
		    String queryDelete = "DELETE FROM dream.user WHERE ssn = ?";
		    try (Connection con = DataBasecon.getConnection();
		         PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
		        stmtDelete.setInt(1, ssn);
		        int rowsAffected = stmtDelete.executeUpdate();
		        if (rowsAffected > 0) {
		            JOptionPane.showMessageDialog(null, "User removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		       return true;
		        }
		    } catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "Error removing User: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		      
		    }
		    return false;
		}

}













