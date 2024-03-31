package softwareproject;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Studio {
    
	private int number;
	private String name;
	private int price;
	private String city;
	private String package1;
	private static final String SUCCESS = "Success"; 
	private static final String ERROR = "Error"; 
	
	
	public Studio() {
		number = -1;
		name = null;
		price = -1;
		city = null;
		package1 = null;
				
	}
	public boolean areTheFieldsNull(int number, String name, int price, String city, String package1) {
	 return name == null || number == -1 || price == -1 || city == null || package1 == null;
	}
	public void refreshStudio(DefaultTableModel model, String city, Date date, int price, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.studio = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.studio c ");
	    boolean whereClauseAdded = false;

	    if (city != null || price > 0 || date != null) {
	        queryBuilder.append("WHERE ");
	        if (city != null) {
	            queryBuilder.append("c.city = ? ");
	            whereClauseAdded = true;
	        }
	        if (price > 0) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("c.price <= ? ");
	            whereClauseAdded = true;
	        }
	        if (date != null) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.studio = c.number AND e.date = ?) ");
	        }
	    }

	    queryBuilder.append("OR ");
	    queryBuilder.append("EXISTS (SELECT 1 FROM dream.event e WHERE e.studio = c.number AND e.number = ?) ");
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
	        if (date != null) {
	            q.setDate(parameterIndex++, date);
	        }
	        q.setInt(parameterIndex++, currentEventSerialNumber);

	        try (ResultSet rs = q.executeQuery()) {
	            while (rs.next()) {
	                Object[] rowData = {
	                    rs.getInt("number"),
	                    rs.getString("name"),
	                    rs.getInt("price"),
	                    rs.getString("package"),
	                    rs.getString("city"),
	                    rs.getBoolean("booked")
	                };
	                model.addRow(rowData);
	            }
	        }
	    } catch (SQLException ex) {
	    }
	    model.fireTableDataChanged();
	}

	public boolean studioAlreadyAdded(int number) throws SQLException {
	    String query = "SELECT COUNT(*) FROM dream.studio WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query)) {
	        q.setInt(1, number);
	        ResultSet rs = q.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        return count > 0;
	    }
	}

	
	public boolean addStudio(int number, String name, int price, String city, String package1) {
	    boolean isAdded = false;
	    if (areTheFieldsNull(number, name, price, city, package1)) {
	        JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
	        return isAdded;
	    }
	    
	    try {
	        if (studioAlreadyAdded(number)) {
	            JOptionPane.showMessageDialog(null, "This studio was already added", "Warning", JOptionPane.WARNING_MESSAGE);
	            return isAdded;
	        }
	        
	        String query = "INSERT INTO dream.studio (number, name, price, city, package) VALUES (?, ?, ?, ?, ?)";
	        try (Connection con = DataBasecon.getConnection();
	             PreparedStatement q = con.prepareStatement(query)) {
	            q.setInt(1, number);
	            q.setString(2, name);
	            q.setInt(3, price);
	            q.setString(4, city);
	            q.setString(5, package1);
	            q.executeUpdate();
	            isAdded = true;
	            JOptionPane.showMessageDialog(null, "Studio added successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException | HeadlessException e) {
	    }
	    return isAdded;
	}


	public boolean editStudio(int studioNumber, String newName, int newPrice, String newCity, String newPackage) {
	    boolean isUpdated = false;
	    try (Connection con = DataBasecon.getConnection()) {
	        String queryUpdate = "UPDATE dream.studio SET name = ?, price = ?, city =?, package = ? WHERE number = ?";
	        try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
	            stmtUpdate.setString(1, newName);
	            stmtUpdate.setInt(2, newPrice);
	            stmtUpdate.setString(3, newCity);
	            stmtUpdate.setString(4, newPackage);
	            stmtUpdate.setInt(5, studioNumber);
	            
	            int rowsUpdated = stmtUpdate.executeUpdate();
	            if (rowsUpdated > 0) {
	                isUpdated = true;
	                JOptionPane.showMessageDialog(null, "Studio updated successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error updating studio: " + e.getMessage(), ERROR, JOptionPane.ERROR_MESSAGE);
	    }
	    return isUpdated;
	}
	public boolean removeStudio(int number) {
	    boolean isRemoved = false;
	    String queryDelete = "DELETE FROM dream.studio WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
	        stmtDelete.setInt(1, number);
	        int rowsAffected = stmtDelete.executeUpdate();
	        if (rowsAffected > 0) {
	            isRemoved = true;
	            JOptionPane.showMessageDialog(null, "Studio removed successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Studio not found.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error removing studio: " + e.getMessage(), ERROR, JOptionPane.ERROR_MESSAGE);
	    }
	    return isRemoved;
	}


  public void setNumber(int number) {
       this.number = number;
   }

   public int getNumber() {
       return number;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getName() {
       return name;
   }

   public void setPrice(int price) {
       this.price = price;
   }

   public int getPrice() {
       return price;
   }
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPackage1() {
		return package1;
	}
	public void setPackage1(String package1) {
		this.package1 = package1;
	}
}
	
