package softwareproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Venue {

	private int number;
	private String name;
	private int price;
	private int capacity;
	private String location;
	private String description;
	private String city;
	static final  String SUCCESS_CONSTANT = "Success";
	public Venue(){
                number = -1;
		name = null;
		capacity = -1;
		location = null;
		description = null;
		city = null;
	}

	
	public boolean areTheFieldsNull(int number, String name, int price, int capacity, String location, String description, String city) {
            return name == null || location == null || description == null || number == -1 || price == -1 || capacity == -1 || city == null;
		
	}
	public boolean refreshVenue(DefaultTableModel model, String city, Date date, int price, int guests, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.venue c ");
	    boolean whereClauseAdded = false;
	    if (city != null || price > 0 || guests> 0 || date != null) {
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
	    if (guests> 0) {
	        addAndIfNeeded(queryBuilder, whereClauseAdded);
	        queryBuilder.append("c.capacity >= ? ");
	        whereClauseAdded = true;
	    }
	    if (date != null) {
	        addAndIfNeeded(queryBuilder, whereClauseAdded);
	        queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.date = ?) ");
	    }


	    queryBuilder.append("OR EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.number = ?) ");
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
	        if (guests>0) {
	            q.setInt(parameterIndex++,guests);
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
		                        rs.getInt("capacity"),
		                        rs.getString("description"),
		                        rs.getString("location"),
		                        rs.getBoolean("booked")
		                };
	                model.addRow(rowData);
	            }
	        }
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
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

	public boolean venueAlreadyAdded(int number) throws SQLException {
		  String query = "SELECT COUNT(*) FROM dream.venue WHERE number = ?";
		  try (Connection con = DataBasecon.getConnection();
			         PreparedStatement q = con.prepareStatement(query)) {
			        q.setInt(1, number);
			        ResultSet rs = q.executeQuery();
			        rs.next();
			        int count = rs.getInt(1);
			        return count > 0;
			    }
		  }
	
	public boolean addVenue(int number, String name, int price, int capacity, String city, String location, String description) throws SQLException {
	    if (areTheFieldsNull(number, name, price, capacity, location, description, city)) {
	        JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }

	    if (venueAlreadyAdded(number)) {
	        JOptionPane.showMessageDialog(null, "This venue was already added", "Warning", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }

	    String query = "INSERT INTO dream.venue (number, name, price, capacity ,location ,description, city) VALUES (?, ?, ?, ?, ?, ?,?)";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query)) {
	        q.setInt(1, number);
	        q.setString(2, name);
	        q.setInt(3, price);
	        q.setInt(4, capacity);
	        q.setString(5, location);
	        q.setString(6, description);
	        q.setString(7, city);
	        q.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Venue added successfully.", SUCCESS_CONSTANT, JOptionPane.INFORMATION_MESSAGE);
	        return true;
	    } catch (SQLException e) {
	        return false;
	    }
	}

	public boolean editVenue(String newName, int newPrice, int newCapacity, String newLocation, String newCity, String newDescription, int venueNumber) {
	    boolean isUpdated = false;
	    try (Connection con = DataBasecon.getConnection()) {
	        String queryUpdate = "UPDATE dream.venue SET name = ?, price = ?, capacity = ?, location = ?, description = ?, city =? WHERE number = ?";
	        try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
	            stmtUpdate.setString(1, newName);
	            stmtUpdate.setInt(2, newPrice);
	            stmtUpdate.setInt(3, newCapacity);
	            stmtUpdate.setString(4, newLocation);
	            stmtUpdate.setString(5, newDescription);
	            stmtUpdate.setInt(7, venueNumber);
	            stmtUpdate.setString(6, newCity);

	            int rowsUpdated = stmtUpdate.executeUpdate();

	            if (rowsUpdated > 0) {
	                isUpdated = true;
	                JOptionPane.showMessageDialog(null, "Venue updated successfully.", SUCCESS_CONSTANT, JOptionPane.INFORMATION_MESSAGE);
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error updating venue: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return isUpdated;
	}




	public boolean removeVenue(int number) {
	    boolean isRemoved = false;
	    String queryDelete = "DELETE FROM dream.venue WHERE number = ?";
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
	        stmtDelete.setInt(1, number);
	        int rowsAffected = stmtDelete.executeUpdate();
	        if (rowsAffected > 0) {
	            isRemoved = true;
	            JOptionPane.showMessageDialog(null, "Venue removed successfully.", SUCCESS_CONSTANT, JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error removing venue: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return isRemoved;
	}

       public void setNumber(int number) {
      this.number = number;
  }

  public void setName(String name) {
      this.name = name;
  }

  public void setPrice(int price) {
      this.price = price;
  }

  public void setCapacity(int capacity) {
      this.capacity = capacity;
  }

  public void setLocation(String location) {
      this.location = location;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public int getNumber() {
      return number;
  }

  public String getName() {
      return name;
  }

  public int getPrice() {
      return price;
  }

  public int getCapacity() {
      return capacity;
  }

  public String getLocation() {
      return location;
  }

  public String getDescription() {
      return description;
  }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}