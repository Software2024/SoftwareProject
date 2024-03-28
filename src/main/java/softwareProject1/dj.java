package softwareProject1;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dj {
	public int number;
	public String name;
	public int price;
	
	
	public dj() {
		number = -1;
		name = null;
		price= -1; }

	public boolean areTheFieldsNull() {
		if (name == null || number == -1 || price == -1) {
			  return true;
		} else 
		return false;
		
	}
	public void refreshDj(DefaultTableModel model, String city, Date date, int price, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.dj = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.dj c ");
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
	            queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.dj = c.number AND e.date = ?) ");
	            whereClauseAdded = true;
	        }
	    }

	    queryBuilder.append("OR ");
	    queryBuilder.append("EXISTS (SELECT 1 FROM dream.event e WHERE e.dj = c.number AND e.number = ?) ");
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
	                    rs.getString("city"),
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



	public boolean djAlreadyAdded(int number) throws SQLException {
		 String query = "SELECT COUNT(*) FROM dream.dj WHERE number = ?";
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
	
	public void addDj(int number, String name, int price,String city) throws HeadlessException, SQLException {
		  if (areTheFieldsNull()) {
		        if (!djAlreadyAdded(number)) {
		            String query = "INSERT INTO dream.dj (number, name, price,city) VALUES (?, ?, ?,?)";
		            try (Connection con = DataBasecon.getConnection();
		                 PreparedStatement q = con.prepareStatement(query)) {
		                q.setInt(1, number);
		                q.setString(2, name);
		                q.setInt(3, price);
		                q.setString(4,city);
		                q.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Dj successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "This dj was already added", "Warning", JOptionPane.WARNING_MESSAGE);
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
		    }
		}
	
	public void editDj(int djNumber, String newName, int newPrice,String city) {
		 try (Connection con = DataBasecon.getConnection()) {
       String queryUpdate = "UPDATE dream.dj SET name = ?, price = ?,city=? WHERE number = ?";
       try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
           stmtUpdate.setString(1, newName);
           stmtUpdate.setInt(2, newPrice);
           stmtUpdate.setString(3,city);
           stmtUpdate.setInt(4, djNumber);
           int rowsUpdated = stmtUpdate.executeUpdate();

           if (rowsUpdated > 0) {
               JOptionPane.showMessageDialog(null, "Dj updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
           }
       }
   } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, "Error updating dj: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
   }
	    }
	public void removeDj(int selectedIndex, int number) {
		 String queryDelete = "DELETE FROM dream.dj WHERE number = ?";
   try (Connection con = DataBasecon.getConnection();
        PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
       stmtDelete.setInt(1, number);
       int rowsAffected = stmtDelete.executeUpdate();
       if (rowsAffected > 0) {
           JOptionPane.showMessageDialog(null, "Dj removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
       }
   } catch (SQLException ex) {
       ex.printStackTrace();
       JOptionPane.showMessageDialog(null, "Error removing Dj: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
   }
}
}
