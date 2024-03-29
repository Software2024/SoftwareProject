package softwareProject1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class venue {

	public int number;
	public String name;
	public int price;
	public int capacity;
	public String location;
	public String description;
	public String city;
	
	public venue(){
		number = -1;
		name = null;
		capacity = -1;
		location = null;
		description = null;
	}
	
	public boolean areTheFieldsNull() {
		if (name == null || location == null || description == null ||
                number == -1 || price == -1 || capacity == -1) {
			  return true;
		} else 
		return false;
		
	}
	public void refreshVenue(DefaultTableModel model, String city, Date date, int price, int guests, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.venue c ");
	    boolean whereClauseAdded = false;

	    if (city != null || price > 0 || guests > 0 || date != null) {
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
	        if (guests > 0) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("c.capacity >= ? ");
	            whereClauseAdded = true;
	        }
	        if (date != null) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.date = ?) ");
	            whereClauseAdded = true;
	        }
	    }
	    
	    queryBuilder.append("OR ");
	    queryBuilder.append("EXISTS (SELECT 1 FROM dream.event e WHERE e.venue = c.number AND e.number = ?) ");
	    
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
	        if (guests > 0) {
	            q.setInt(parameterIndex++, guests);
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
	    }
	    model.fireTableDataChanged();
	}


	
	public boolean venueAlreadyAdded(int number) throws SQLException {
		  String query = "SELECT COUNT(*) FROM dream.venue WHERE number = ?";
		  try (Connection con = DataBasecon.getConnection();
		             PreparedStatement q = con.prepareStatement(query)) {
		            q.setInt(1, number);
		            ResultSet rs = q.executeQuery();
		            rs.next();
		            int count = rs.getInt(1);
		            if (count > 0) {
		            	return true;
		            }
		            else {
		            	return false;
		            }
		  }
	 
	}
	public void addVenue(int number, String name, int price, int capacity, String city,String location, String description) throws SQLException{
	
  
  if (venueAlreadyAdded(number)) {
      JOptionPane.showMessageDialog(null, "This venue was already added", "Warning", JOptionPane.WARNING_MESSAGE);
      return;
  }
  
	                String query = "INSERT INTO dream.venue (number, name, price, capacity ,location ,description,city) VALUES (?, ?, ?, ?, ?, ?,?)";
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
	                    JOptionPane.showMessageDialog(null, "Venue successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
      }
   public void editVenue(String newName, int newPrice, int newCapacity, String newLocation,String newCity, String newDescription, int venueNumber) throws SQLException {
  try (Connection con = DataBasecon.getConnection()) {
      String queryUpdate = "UPDATE dream.venue SET name = ?, price = ?, capacity = ?, city = ?, description = ?,location=? WHERE number = ?";
      try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
          stmtUpdate.setString(1, newName);
          stmtUpdate.setInt(2, newPrice);
          stmtUpdate.setInt(3, newCapacity);
          stmtUpdate.setString(4, newLocation);
          stmtUpdate.setString(5, newDescription);
          stmtUpdate.setString(6, newCity);
          stmtUpdate.setInt(7, venueNumber);

          int rowsUpdated = stmtUpdate.executeUpdate();

          if (rowsUpdated > 0) {
              JOptionPane.showMessageDialog(null, "Venue updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
          }
      }
  } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Error updating venue: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  }
}



	public void removeVenue(int selectedIndex, int number) throws SQLException {
  String queryDelete = "DELETE FROM dream.venue WHERE number = ?";
  try (Connection con = DataBasecon.getConnection();
       PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
      stmtDelete.setInt(1, number);
      int rowsAffected = stmtDelete.executeUpdate();
      if (rowsAffected > 0) {
          JOptionPane.showMessageDialog(null, "Venue removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
     
      }
  } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error removing venue: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  }
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
  public void setCity(String description) {
      this.city = description;
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
	}
