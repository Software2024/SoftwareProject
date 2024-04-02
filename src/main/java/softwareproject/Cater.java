package softwareproject;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cater {
    private int number;
	private String name;
	private int price;
	private String package1;
	private String city;
	private static final String SUCCESS = "Success";
	
	public Cater() {
		number = -1;
		name = null;
		price = -1;
		package1 = null;
		city = null;
	}
	public boolean areTheFieldsNull(int number, String name, int price, String package1 , String city) {
		return (name == null || number == -1 || price == -1 || package1 == null || city == null);
	}
	public boolean refreshCater(DefaultTableModel model, String city, Date date, int price, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.cater = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.cater c ");
	    boolean whereClauseAdded = false;

	    if (city != null || price > 0 || date != null) {
	        queryBuilder.append("WHERE ");
	    }

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
	        queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.cater = c.number AND e.date = ?) ");
	        whereClauseAdded = true;
	    }

	    queryBuilder.append("OR EXISTS (SELECT 1 FROM dream.event e WHERE e.cater = c.number AND e.number = ?) ");
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

	public boolean caterAlreadyAdded(int number) throws SQLException {
	    String query = "SELECT COUNT(*) FROM dream.cater WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query)) {
	        q.setInt(1, number);
	        ResultSet rs = q.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        return count > 0;
	    }
	}

	public boolean addCater(int number, String name, int price, String package1, String city) {
	    boolean isAdded = false;
	    try {
	        if (areTheFieldsNull(number, name, price, package1, city)) {
	            JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        if (caterAlreadyAdded(number)) {
	            JOptionPane.showMessageDialog(null, "This caterer was already added", "Warning", JOptionPane.WARNING_MESSAGE);
	            return false;
	        }

	        String query = "INSERT INTO dream.cater (number, name, price, package, city) VALUES (?, ?, ?, ?, ?)";
	        try (Connection con = DataBasecon.getConnection();
	             PreparedStatement q = con.prepareStatement(query)) {
	            q.setInt(1, number);
	            q.setString(2, name);
	            q.setInt(3, price);
	            q.setString(4, package1);
	            q.setString(5, city);
	            q.executeUpdate();
	            isAdded = true;
	            JOptionPane.showMessageDialog(null, "Caterer added successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException e) {
	        	return false;
	        	        }
	    } catch (HeadlessException | SQLException e) {
	    	return false;
	
	    }
	    return isAdded;
	}

	public boolean editCater(int caterNumber, String newName, int newPrice, String newPackage, String newCity) {
	    boolean isUpdated = false;
	    try (Connection con = DataBasecon.getConnection()) {
	        String queryUpdate = "UPDATE dream.cater SET name = ?, price = ?, package = ?, city = ? WHERE number = ?";
	        try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
	            stmtUpdate.setString(1, newName);
	            stmtUpdate.setInt(2, newPrice);
	            stmtUpdate.setString(3, newPackage);
	            stmtUpdate.setString(4, newCity);
	            stmtUpdate.setInt(5, caterNumber);
	            int rowsUpdated = stmtUpdate.executeUpdate();

	            if (rowsUpdated > 0) {
	                isUpdated = true;
	                JOptionPane.showMessageDialog(null, "Caterer updated successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error updating caterer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return isUpdated;
	}

	public boolean removeCater(int number) {
	    boolean isRemoved = false;
	    String queryDelete = "DELETE FROM dream.cater WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
	        stmtDelete.setInt(1, number);
	        int rowsAffected = stmtDelete.executeUpdate();
	        if (rowsAffected > 0) {
	            isRemoved = true;
	            JOptionPane.showMessageDialog(null, "Caterer removed successfully.", SUCCESS, JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error removing Caterer: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return isRemoved;
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

	    public String getPackage() {
	        return package1;
	    }

	    public void setPackage(String package1) {
	        this.package1 = package1;
	    }
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
}


