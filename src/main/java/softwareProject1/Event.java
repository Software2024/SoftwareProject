package softwareProject1;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Event {
	private int serialNumber;
	public String bride_name;
	public String groom_name;
	private int budget ;
	public Date date ; 
	private Time starting_time;
	private int duration;
	private int guests;
	private int venue;
	private int studio;
	private int dec;
	private int dj;
	private int cater;
	private int total_cost;
	private int creator_id;
	public String theme;
	public String city;
	private static Event instance;
	public Event() {
	 serialNumber=-1;
		 bride_name=null;
	 groom_name=null;
	 budget=0 ;
	date=null ; 
		starting_time=null;
		 duration=-1;
		 guests=-1;
	 venue=-1;
		studio=-1;
	 dec=-1;
		 dj=-1;
		 cater=-1;
	 total_cost=-1;
	 creator_id=-1;
		 theme=null;
		city=null;	
	}
	public static Event getInstance() {
	    if (instance == null) {
	        instance = new Event();
	    }
	    return instance;
	}
	 

	 
	
	public void setGuest(int guests) {
		
		 instance.guests=guests;
	}
	
	public int getGuest() {
	
		 return instance.guests;
	}
	public void  setCity(String city) {
		this.city=city;
	  
	}
	public String getCity() {
		return instance.city;
	}
	
	public void  setSerial(int serial) {
		 instance.serialNumber=serial;
	}
	public int getSerial() {
		return instance.serialNumber;
	}
	
	public void  setTheme(String theme) {
		this.theme=theme;
	  
	}
	public String getTheme() {
		return instance.theme;
	}
	public void  setDate(Date date) {
		this.date=date;
	  
	}
	public Date getDate() {
		return instance.date;
	}
	public int createEvent(int currentUser, String bride_name, String groom_name, int budget, Date date, Time starting_time, int duration, int guests, String theme, String city) {
	 
	    if (isEventExists(bride_name, groom_name)) {
	    

	        JOptionPane.showMessageDialog(null, "The wedding event you are trying to create already exists. Please navigate to the menu and choose manage your events to edit the event's details.");
	        return -1;
	    }

	    if (date.toLocalDate().isBefore(LocalDate.now())) {
	        JOptionPane.showMessageDialog(null, "Error: Event date cannot be in the past.", "Error", JOptionPane.ERROR_MESSAGE);
	        return -1;
	    }

	    int serialNumber = -1; 

	    String query = "INSERT INTO dream.event (\"bride full name\", \"groom full name\", budget, date, \"starting time\", duration, \"guest count\", theme, city_location, \"creater id\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement q = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	        q.setString(1, bride_name);
	        q.setString(2, groom_name);
	        q.setInt(3, budget);
	        q.setDate(4, date);
	        q.setTime(5, starting_time);
	        q.setInt(6, duration);
	        q.setInt(7, guests);
	        q.setString(8, theme);
	        q.setString(9, city);
	        q.setInt(10, currentUser); 

	        int affectedRows = q.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating event failed, no rows affected.");
	        }
	        
	        try (ResultSet generatedKeys = q.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                serialNumber = generatedKeys.getInt(1); 
	            } else {
	                throw new SQLException("Creating event failed, no serial number obtained.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    setDate(date);
	    setCity(city);
	    setTheme(theme);
	    setGuest(guests);
	    setSerial(serialNumber);
	    return serialNumber; 
	}

	

	boolean isEventExists(String bride_name, String groom_name) {
	 
	    String query = "SELECT COUNT(*) FROM dream.event WHERE \"bride full name\" = ? AND \"groom full name\" = ?";
	    
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, bride_name);
	        stmt.setString(2, groom_name);
	      
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	public boolean editEvent(int eventSerialNumber, int serviceNumber, String serviceType,  int servicePrice) {
	    String updateQuery = "";
    if (isBooked2(eventSerialNumber, serviceType)) {
	        JOptionPane.showMessageDialog(null, "" + serviceType + " is already added to your event. Please unbook it first to change your selection.");
	    } else {
	        switch (serviceType) {
	            case "dj":
	                updateQuery = "UPDATE dream.event SET dj = ?, \"total cost\" = \"total cost\" + ? WHERE number = ?";
	                break;
	            case "cater":
	                updateQuery = "UPDATE dream.event SET cater = ?, \"total cost\" = \"total cost\" + ? WHERE number = ?";
	                break;
	            case "decoration":
	                updateQuery = "UPDATE dream.event SET decorations = ?, \"total cost\" = \"total cost\" + ? WHERE number = ?";
	                break;
	            case "venue":
	                updateQuery = "UPDATE dream.event SET venue = ?, \"total cost\" = \"total cost\" + ? WHERE number = ?";
	                break;
	            case "studio":
	                updateQuery = "UPDATE dream.event SET studio = ?, \"total cost\" = \"total cost\" + ? WHERE number = ?";
	                break;
	        }

	        try (Connection con = DataBasecon.getConnection();
	             PreparedStatement stmt = con.prepareStatement(updateQuery)) {
	            stmt.setInt(1, serviceNumber);
	            stmt.setInt(2, servicePrice);
	            stmt.setInt(3, eventSerialNumber);

	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                JOptionPane.showMessageDialog(null, "" + serviceType + " number: " + serviceNumber + " successfully added to your event");
	                return true;
	            } else {
	                JOptionPane.showMessageDialog(null, "Failed to update event.");
	                return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}


	public boolean deleteFromEvent(int eventSerialNumber, int serviceNumber, String serviceType,  int servicePrice ) {
	    String updateQuery = "";
	    if (isBooked(eventSerialNumber,serviceNumber , serviceType,servicePrice)>-1) {
	    	
	      switch (serviceType) {
	        case "dj":
	            updateQuery = "UPDATE dream.event SET \"total cost\" =\"total cost\"-? ,dj=null  WHERE number = ?";
	            break;
	        case "cater":
	            updateQuery = "UPDATE dream.event SET \"total cost\" =\"total cost\"-? ,cater=null  WHERE number = ?";
	            break;
	        case "decoration":
	            updateQuery = "UPDATE dream.event SET \"total cost\" =\"total cost\"-? ,decorations=null  WHERE number = ?";
	            break;
	        case "venue":
	            updateQuery = "UPDATE dream.event SET \"total cost\" =\"total cost\"-? ,venue=null  WHERE number = ?";
	            break;
	        case "studio":
	            updateQuery = "UPDATE dream.event SET \"total cost\" =\"total cost\"-? ,studio=null  WHERE number = ?";
	            break;
	      
	    }

	    try (Connection con = DataBasecon.getConnection();
	            PreparedStatement stmt = con.prepareStatement(updateQuery)) {
	         
	           stmt.setInt(1, servicePrice);
	           stmt.setInt(2, eventSerialNumber);

	           int rowsAffected = stmt.executeUpdate();
	           if (rowsAffected > 0) {
	        	   JOptionPane.showMessageDialog(null,""+ serviceType + " number: " + serviceNumber+"successfully deleted from your event");
	        	   return true;
	           } else {
	        	   JOptionPane.showMessageDialog(null,"Failed to delete the service from the event.");
	               return false;
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	    
	    } else JOptionPane.showMessageDialog(null, "you didn't book this service .", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	}
public int isBooked(int serial,int service ,String serviceType,int price) {
	   String countQuery = "";
	    
	      switch (serviceType) {
	        case "dj":
	        	countQuery = " SELECT  1 from dream.event where dj=? and number = ?";
	            break;
	        case "cater":
	        	countQuery = " SELECT  1 from dream.event where cater=? and number = ?";
	            break;
	        case "decoration":
	        	countQuery = " SELECT  1 from dream.event where decorations=? and number = ?";
	            break;
	        case "venue":
	        	countQuery = " SELECT  1 from dream.event where venue=? and number = ?";
	            break;
	        case "studio":
	        	countQuery= "SELECT 1 from dream.event where studio=? and number = ?";
	            break;
	       
	    }

	    try (Connection con = DataBasecon.getConnection();
	            PreparedStatement stmt = con.prepareStatement(countQuery)) {
	           stmt.setInt(1, service);
	     
	           stmt.setInt(2, serial);

	           try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		            	 return price; 
		            }else return -1;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return -1;
		    }
		
}
public void deleteEvent(int serial) {
	
	    String deleteQuery = "DELETE FROM dream.event WHERE number = ?";
	    
	    try (Connection con = DataBasecon.getConnection();
	         PreparedStatement stmt = con.prepareStatement(deleteQuery)) {
	        stmt.setInt(1, serial);

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	        	

	            JOptionPane.showMessageDialog(null, "Event with serial number " + serial + " has been deleted successfully.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to delete event with serial number " + serial + ".");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "An error occurred while deleting the event with serial number " + serial + ".");
	    
	}

}

public boolean isBooked2(int serial, String serviceType) {
    String column = "";
    switch (serviceType) {
        case "dj":
            column = "dj";
            break;
        case "cater":
            column = "cater";
            break;
        case "decoration":
            column = "decorations";
            break;
        case "venue":
            column = "venue";
            break;
        case "studio":
            column = "studio";
            break;
    }

    String countQuery = "SELECT 1 FROM dream.event WHERE " + column + " IS NOT NULL AND number = ?";

    try (Connection con = DataBasecon.getConnection();
         PreparedStatement stmt = con.prepareStatement(countQuery)) {
        stmt.setInt(1, serial);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next(); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public String retrieveEventData(DefaultTableModel model, int eventSerialNumber) {
    String query = "SELECT budget, \"total cost\", dj, cater, studio, venue, decorations FROM dream.event WHERE number = ?";

    try (Connection con = DataBasecon.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setInt(1, eventSerialNumber);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
               int budget = rs.getInt("budget");
               int totalCost = rs.getInt("total cost");
                int djNumber = rs.getInt("dj");
                int catererNumber = rs.getInt("cater");
                int studioNumber = rs.getInt("studio");
                int venueNumber = rs.getInt("venue");
                int decorationsNumber = rs.getInt("decorations");

                int djPrice = getServicePrice("dj", djNumber);
                int catererPrice = getServicePrice("cater", catererNumber);
                int studioPrice = getServicePrice("studio", studioNumber);
                int venuePrice = getServicePrice("venue", venueNumber);
                int decorationsPrice = getServicePrice("decorations", decorationsNumber);

              
                model.addRow(new Object[]{budget, totalCost, djPrice, 
                       studioPrice, venuePrice,catererPrice, decorationsPrice});
           return  generateReport(budget, totalCost,djPrice, catererPrice, studioPrice,  venuePrice,  decorationsPrice);
            
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return null;
}



    private int getServicePrice(String serviceType, int serviceNumber) {
        int servicePrice = 0;
        String query = "";
        String column = "";

        switch (serviceType) {
            case "dj":
                column = "dj";
                break;
            case "cater":
                column = "cater";
                break;
            case "decorations":
                column = "decorations";
                break;
            case "venue":
                column = "venue";
                break;
            case "studio":
                column = "studio";
                break;
        }

        if (!column.isEmpty()) {
            query = "SELECT price FROM dream." + column + " WHERE number = ?";
        }

        try (Connection con = DataBasecon.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, serviceNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    servicePrice = rs.getInt("price");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicePrice;
    }
    public String generateReport(int budget, int totalCost, int djPrice, int catererPrice, int studioPrice, int venuePrice, int decorationsPrice) {
        StringBuilder report = new StringBuilder();
        
      
        
       
        double djPercentage = (djPrice / (double) totalCost) * 100;
        double catererPercentage = (catererPrice / (double) totalCost) * 100;
        double studioPercentage = (studioPrice / (double) totalCost) * 100;
        double venuePercentage = (venuePrice / (double) totalCost) * 100;
        double decorationsPercentage = (decorationsPrice / (double) totalCost) * 100;
      
        report.append("Budget: $").append(budget).append("\n");
        report.append("Total Cost: $").append(totalCost).append("\n");
        report.append("Percentage breakdown of service costs of the total payment:\n");
        report.append("- DJ: ").append(String.format("%.2f", djPercentage)).append("%\n");
        report.append("- Caterer: ").append(String.format("%.2f", catererPercentage)).append("%\n");
        report.append("- Studio: ").append(String.format("%.2f", studioPercentage)).append("%\n");
        report.append("- Venue: ").append(String.format("%.2f", venuePercentage)).append("%\n");
        report.append("- Decorations: ").append(String.format("%.2f", decorationsPercentage)).append("%\n");
        if (totalCost>budget) {
            
            double budgetExceeded = totalCost - budget;
            report.append("Total Cost Exceeds Budget by: $").append(budgetExceeded);
            }else {
            	 double budgetExceeded =  budget-totalCost;
                 report.append("Money Saved: $").append(budgetExceeded);
            }
         return report.toString();
    }
    public  boolean editEventInfo(int serialNumber, String brideName, String groomName, int budget, Date date, int guests, String theme, String city) {
        String updateQuery = "UPDATE dream.event SET \"bride full name\" = ?, \"groom full name\" = ?, budget = ?, date = ?, \"guest count\" = ?, theme = ?, city_location = ?, dj = NULL, cater = NULL, studio = NULL, venue = NULL, decorations = NULL, \"total cost\" = 0 WHERE number = ?";
        
        try (Connection con = DataBasecon.getConnection();
             PreparedStatement stmt = con.prepareStatement(updateQuery)) {
            stmt.setString(1, brideName);
            stmt.setString(2, groomName);
            stmt.setInt(3, budget);
            stmt.setDate(4,date);
            stmt.setInt(5, guests);
            stmt.setString(6, theme);
            stmt.setString(7, city);
            stmt.setInt(8, serialNumber);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
	
	
	
	

