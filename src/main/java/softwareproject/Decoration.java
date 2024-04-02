package softwareproject;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Decoration {
    private int number;
	private String name;
	private int price;
	private String theme;
	private String city;
	private static final String ERROR = "Error";
	private static final String SUCCESS = "Success";
	
	public Decoration() {
		number = -1;
		name = null;
		price = -1;
		theme = null;
		city = null;
	}
	public boolean areTheFieldsNull(int number, String name, int price, String theme, String city) {
		return (name == null || number == -1 || price == -1 || theme == null || city == null);
	}
	public boolean refreshDec(DefaultTableModel model, String city, Date date, int price, String theme, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.decorations = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.decorations c ");
	    boolean whereClauseAdded = false;
	    if (city != null || price > 0 || theme != null || date != null) {
	        queryBuilder.append("WHERE ");
	    }
	    if (city != null) {
	        queryBuilder.append(" c.city = ? ");
	        whereClauseAdded = true;
	    }
	    if (price > 0) {
	        addAndIfNeeded(queryBuilder, whereClauseAdded);
	        queryBuilder.append("c.price <= ? ");
	        whereClauseAdded = true;
	    }
	    if (theme != null) {
	        addAndIfNeeded(queryBuilder, whereClauseAdded);
	        queryBuilder.append("c.theme = ? ");
	        whereClauseAdded = true;
	    }
	    if (date != null) {
	        addAndIfNeeded(queryBuilder, whereClauseAdded);
	        queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.decorations = c.number AND e.date = ?) ");
	    }


	    queryBuilder.append("OR EXISTS (SELECT 1 FROM dream.event e WHERE e.decorations = c.number AND e.number = ?) ");
	    queryBuilder.append("ORDER BY c.number ASC");

	    String query = queryBuilder.toString();

	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query)) {

	        int parameterIndex = 1;
	        q.setInt(parameterIndex++, currentEventSerialNumber);

	        if (city != null) {
	            q.setString(parameterIndex++, city);
	        }
	        if (price > 0) {
	            q.setInt(parameterIndex++, price);
	        }
	        if (theme != null) {
	            q.setString(parameterIndex++, theme);
	        }
	        if (date != null) {
	            q.setDate(parameterIndex++, date);
	        }
	        q.setInt(parameterIndex++, currentEventSerialNumber);

	        try (ResultSet rs = q.executeQuery()) {
	            while (rs.next()) {
	                Object[] rowData = {
	                    rs.getInt("number"),
	                    rs.getString("name"),
	                    rs.getString("theme"),
	                    rs.getInt("price"),
	                    rs.getString("city"),
	                    rs.getBoolean("booked")
	                };
	                model.addRow(rowData);
	            }
	        }
	    } catch (SQLException ex) {
	    	return false;
	    }
	    model.fireTableDataChanged();
	    return true;
	}

	private void addAndIfNeeded(StringBuilder queryBuilder, boolean whereClauseAdded) {
	    if (whereClauseAdded) {
	        queryBuilder.append("AND ");
	    }
	}




	public boolean decorationAlreadyAdded(int number) throws SQLException {
		 String query = "SELECT COUNT(*) FROM dream.decorations WHERE number = ?";
		 try (Connection con = DataBasecon.getConnection();
		         PreparedStatement q = con.prepareStatement(query)) {
		        q.setInt(1, number);
		        ResultSet rs = q.executeQuery();
		        rs.next();
		        int count = rs.getInt(1);
		        return count > 0;
		    }
	}
	public boolean addDecorations(int number, String name, int price, String theme, String city) throws HeadlessException, SQLException {
	    boolean isAdded = false;
	    if (areTheFieldsNull(number, name, price, theme, city)) {
	        JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
	        return isAdded;
	    }

	    if (decorationAlreadyAdded(number)) {
	        JOptionPane.showMessageDialog(null, "This decoration was already added", "Warning", JOptionPane.WARNING_MESSAGE);
	        return isAdded;
	    }

	    String query = "INSERT INTO dream.decorations (number, name, price, theme, city) VALUES (?, ?, ?, ?, ?)";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query)) {
	        q.setInt(1, number);
	        q.setString(2, name);
	        q.setInt(3, price);
	        q.setString(4, theme);
	        q.setString(5, city);
	        q.executeUpdate();
	        isAdded = true;
	        JOptionPane.showMessageDialog(null, "Decoration added successfully.", SUCCESS , JOptionPane.INFORMATION_MESSAGE);
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error occurred while adding decoration: " + e.getMessage(), ERROR , JOptionPane.ERROR_MESSAGE);
	    }
	    return isAdded;
	}

	public boolean editDecoration(int decorNumber, String newName, int newPrice, String newTheme, String newCity) {
	    boolean isUpdated = false;
	    try (Connection con = DataBasecon.getConnection()) {
	        String queryUpdate = "UPDATE dream.decorations SET name = ?, price = ?, theme = ?, city = ? WHERE number = ?";
	        try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
	            stmtUpdate.setString(1, newName);
	            stmtUpdate.setInt(2, newPrice);
	            stmtUpdate.setString(3, newTheme);
	            stmtUpdate.setString(4, newCity);
	            stmtUpdate.setInt(5, decorNumber);
	            
	            int rowsUpdated = stmtUpdate.executeUpdate();

	            if (rowsUpdated > 0) {
	                isUpdated = true;
	                JOptionPane.showMessageDialog(null, "Decoration updated successfully.", SUCCESS , JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error updating decoration: " + e.getMessage(), ERROR, JOptionPane.ERROR_MESSAGE);
	    }
	    return isUpdated;
	}

	public boolean removeDecoration(int number) {
	    boolean success = false;
	    String queryDelete = "DELETE FROM dream.decorations WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
	        stmtDelete.setInt(1, number);
	        int rowsAffected = stmtDelete.executeUpdate();
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Decoration removed successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	            success = true;
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error removing decoration: " + ex.getMessage(), ERROR , JOptionPane.ERROR_MESSAGE);
	    }
	    return success;
	}

	 public int getNumber() {
	        return number;
	    }

	    public void setNumber(int number) {
	        this.number = number;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public String getTheme() {
	        return theme;
	    }

	    public void setTheme(String theme) {
	        this.theme = theme;
	    }
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
}
