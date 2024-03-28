package softwareProject1;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class decoration {
	public int number;
	public String name;
	public int price;
	public String theme;
	
	public decoration() {
		number = -1;
		name = null;
		price = -1;
		theme = null;
	}
	public boolean areTheFieldsNull() {
		if (name == null || number == -1 || price == -1 || theme == null) {
			  return true;
		} else 
		return false;
		
	}
	public void refreshDec(DefaultTableModel model, String city, Date date, int price, String theme, int currentEventSerialNumber) {
	    model.setRowCount(0);
	    StringBuilder queryBuilder = new StringBuilder("SELECT c.*, ");
	    queryBuilder.append("CASE WHEN EXISTS (SELECT 1 FROM dream.event e WHERE e.decorations = c.number AND e.number = ?) THEN TRUE ELSE FALSE END AS booked ");
	    queryBuilder.append("FROM dream.decorations c ");
	    boolean whereClauseAdded = false;

	    if (city != null || price > 0 || theme != null || date != null) {
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
	        if (theme != null) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("c.theme = ? ");
	            whereClauseAdded = true;
	        }
	        if (date != null) {
	            if (whereClauseAdded) {
	                queryBuilder.append("AND ");
	            }
	            queryBuilder.append("NOT EXISTS (SELECT 1 FROM dream.event e WHERE e.decorations = c.number AND e.date = ?) ");
	            whereClauseAdded = true;
	        }
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
	        ex.printStackTrace();
	    }
	    model.fireTableDataChanged();
	}



	public boolean decorationAlreadyAdded(int number) throws SQLException {
		 String query = "SELECT COUNT(*) FROM dream.decorations WHERE number = ?";
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
	public void addDecorations(int number, String name, int price, String theme,String city) throws HeadlessException, SQLException {
		  if (areTheFieldsNull()) {
		        if (!decorationAlreadyAdded(number)) {
		            String query = "INSERT INTO dream.decorations (number, name, price, theme,city) VALUES (?, ?, ?, ?,?)";
		            try (Connection con = DataBasecon.getConnection();
		                 PreparedStatement q = con.prepareStatement(query)) {
		                q.setInt(1, number);
		                q.setString(2, name);
		                q.setInt(3, price);
		                q.setString(4, theme);
		                q.setString(5, city);
		                q.executeUpdate();
		                JOptionPane.showMessageDialog(null, "Decoration successfully added!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "This decoration was already added", "Warning", JOptionPane.WARNING_MESSAGE);
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "You can't leave any of the fields empty!", "Warning", JOptionPane.WARNING_MESSAGE);
		    }
		}
	public void editDecoration(int djNumber, String newName, int newPrice, String newTheme,String city) {
	     try (Connection con = DataBasecon.getConnection()) {
       String queryUpdate = "UPDATE dream.decorations SET name = ?, price = ?, theme = ?,city=? WHERE number = ?";
       try (PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate)) {
           stmtUpdate.setString(1, newName);
           stmtUpdate.setInt(2, newPrice);
           stmtUpdate.setString(3, newTheme);
           stmtUpdate.setString(4, city);
           stmtUpdate.setInt(5, djNumber);
           int rowsUpdated = stmtUpdate.executeUpdate();

           if (rowsUpdated > 0) {
               JOptionPane.showMessageDialog(null, "Decoration updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
           }
       }
   } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, "Error updating decoration: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
   }
	}
	public void removeDecoration(int selectedIndex, int number) {
	 String queryDelete = "DELETE FROM dream.decorations WHERE number = ?";
   try (Connection con = DataBasecon.getConnection();
        PreparedStatement stmtDelete = con.prepareStatement(queryDelete)) {
       stmtDelete.setInt(1, number);
       int rowsAffected = stmtDelete.executeUpdate();
       if (rowsAffected > 0) {
           JOptionPane.showMessageDialog(null, "decoration removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
      
       }
   } catch (SQLException ex) {
       ex.printStackTrace();
       JOptionPane.showMessageDialog(null, "Error removing decoration: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
   }
}


}
