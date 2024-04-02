package softwareproject;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class FilterTest {
	JTable table;
	Decoration dec;
    Dj dj;
    Studio std;
    Cater cater;
    Venue venue;
    Event event=new Event();
    private int price;
    DefaultTableModel model;
    int rows;
	private boolean x;
	private Map<String, Object> criteria;
	private Event event1;
	private String city;
	private String theme;
	private int guests;

    
	@Given("I have a table {string}")
	public void i_have_a_table(String string) {
	     table =new JTable();
	}

	@Given("I have entered city as {string}, theme as {string}, price as {int}, date as {string}")
	public void i_have_entered_city_as_theme_as_price_as_date_as(String string, String string2, Integer int1, String string3) {
		event =Event.getInstance();
		event.setCity("nablus");
		 event.setDate(Date.valueOf("2025-06-06"));
		 event.setTheme("Cultural Ethnic");
	event.setSerial(157);
	this.price=400;
	}

	@When("the table is displayed")
	public void the_table_is_displayed() {
         dec = new Decoration();
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 x = dec.refreshDec(model,event.getCity(),event.getDate(),price,event.getTheme(),event.getSerial());
		 assertTrue(x);
		rows= model.getRowCount();
	}

	@Then("all results should match the criteria of the decoration that the user entered")
	public void all_results_should_match_the_criteria_of_the_decoration_that_the_user_entered() {
	    criteria = new HashMap<>();
		criteria.put("city", "nablus");
		criteria.put("price", 400);
		criteria.put("theme", "Cultural Ethnic");
	
		int expectedRowCount=getExpectedRowCountFromDatabase("decorations", criteria);
		 assertEquals(expectedRowCount,rows);
	}

	@Given("I have entered city as null, theme as null, price as null, date as null")
	public void i_have_entered_city_as_null_theme_as_null_price_as_null_date_as_null() {
		 criteria = new HashMap<>();
		 criteria.put("city", null);
		    criteria.put("theme", null);
		    criteria.put("price",null);
		    event1=new Event();
		 event1.setSerial(175);
		this.price=-1;
		}

	@Then("the result will be all the decoration table content")
	public void the_result_will_be_all_the_decoration_table_content() {
		   dec = new Decoration();
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
			 x = dec.refreshDec(model,city,event1.getDate(),price,theme,event1.getSerial());
			 this.rows= model.getRowCount();
			 assertTrue(x);
				int expectedRowCount=getExpectedRowCountFromDatabase("decorations",criteria);
				 assertEquals(expectedRowCount,this.rows);
			
	}

	@Given("I have entered city as {string}, price as {int}, date as {string}")
	public void i_have_entered_city_as_price_as_date_as(String string, Integer int1, String string2) {
		 event = new Event();
			event.setCity("nablus");
			 event.setDate(Date.valueOf("2025-06-06"));
		event.setSerial(175);
		this.price=2500;
	}

	@When("the dj table is displayed")
	public void the_dj_table_is_displayed() {
		 criteria = new HashMap<>();
		 criteria.put("city",event.getCity());
		    criteria.put("price",price);
		    criteria.put("date",event.getDate());
		   dj = new Dj();
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
			 model.setRowCount(0);
			 x = dj.refreshDj(model,event.getCity(),event.getDate(), price,event.getSerial());
			 this.rows=model.getRowCount();
			 
	}

	@Then("all results should match the criteria of the dj that the user entered")
	public void all_results_should_match_the_criteria_of_the_dj_that_the_user_entered() {
		
	 assertTrue(x);
	 int expectedRowCount=getExpectedRowCountFromDatabase("dj",criteria);
	 assertEquals(expectedRowCount,this.rows);
	}

	@Given("I have entered city as null, price as null, date as null")
	public void i_have_entered_city_as_null_price_as_null_date_as_null() {
		 event = new Event();
		this.price=-1;
		event.setSerial(175);
		
	}

	@Then("the result will be all the dj table content")
	public void the_result_will_be_all_the_dj_table_content() {
		dj=new Dj();
		 criteria = new HashMap<>();
		 criteria.put("city", null);
		 criteria.put("price",null);
		 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		 x = dj.refreshDj(model,city,event.getDate(),this.price,event.getSerial());
		 this.rows=model.getRowCount();
		 assertTrue(x); 
		 int expectedRowCount=getExpectedRowCountFromDatabase("dj",criteria);
		 assertEquals(expectedRowCount,this.rows);
	}

	@When("the studio table is displayed")
	public void the_studio_table_is_displayed() {
		event.setCity("nablus");
		 event.setDate(Date.valueOf("2025-06-06"));
	event.setSerial(175);
	this.price=2000;
		std=new Studio();
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		 x = std.refreshStudio(model,event.getCity(), event.getDate(), price, event.getSerial());
		 this.rows=model.getRowCount();
	}

	@Then("all results should match the criteria of the studio that the user entered")
	public void all_results_should_match_the_criteria_of_the_studio_that_the_user_entered() {
		assertTrue(x);
		 criteria = new HashMap<>();
		 criteria.put("city",event.getCity());
		 criteria.put("price",this.price);
		 criteria.put("date",event.getDate());
		 int expectedRowCount=getExpectedRowCountFromDatabase("studio",criteria);
		 assertEquals(expectedRowCount,this.rows);
		
	}

	@Then("the result will be all the studio table content")
	public void the_result_will_be_all_the_studio_table_content() {
		event=new Event();
		std=new Studio();
		 criteria = new HashMap<>();
		 criteria.put("city", null);
		 criteria.put("price",null);
		 this.price=-1;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		 x = std.refreshStudio(model,city,event.getDate(),this.price,event.getSerial());
		 this.rows=model.getRowCount();
		 assertTrue(x); 
		 int expectedRowCount=getExpectedRowCountFromDatabase("studio",criteria);
		 assertEquals(expectedRowCount,this.rows);
	}

	@When("the cater table is displayed")
	public void the_cater_table_is_displayed() {
		cater=new Cater();
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		 x =cater.refreshCater(model, event.getCity(), event.getDate(), price, event.getSerial());
		
	}

	@Then("all results should match the criteria of the cater that the user entered")
	public void all_results_should_match_the_criteria_of_the_cater_that_the_user_entered() {
		assertTrue(x);
		 criteria = new HashMap<>();
		 criteria.put("city",event.getCity());
		 criteria.put("price",this.price);
		 criteria.put("date",event.getDate());
		 int expectedRowCount=getExpectedRowCountFromDatabase("cater",criteria);
		 assertEquals(expectedRowCount,this.rows);
		
	}

	@Then("the result will be all the cater table content")
	public void the_result_will_be_all_the_cater_table_content() {
		cater=new Cater();
		event=new Event();
		 criteria = new HashMap<>();
		 criteria.put("city", null);
		 criteria.put("price",null);
		 this.price=-1;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		 x =cater.refreshCater(model,city, event.getDate(),price, event.getSerial());
		 this.rows=model.getRowCount();
		 assertTrue(x); 
		 int expectedRowCount=getExpectedRowCountFromDatabase("cater",criteria);
		 assertEquals(expectedRowCount,this.rows);
		
	}

	@Given("I have entered city as {string}, price as {int}, date as {string}, guests as {int}")
	public void i_have_entered_city_as_price_as_date_as_guests_as(String string, Integer int1, String string2, Integer int2) {
		event = new Event();
		event.setCity("nablus");
		event.setDate(Date.valueOf("2025-06-06"));
		event.setGuest(200);
		event.setSerial(175);
		this.price=3000;
	}

	@When("the venue table is displayed")
	public void the_venue_table_is_displayed() {
		venue =new Venue();
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0);
		 x =venue.refreshVenue(model,event.getCity(), event.getDate(),this.price,event.getGuest(), event.getSerial());
		 assertTrue(x);
		
		 
	}

	@Then("all results should match the criteria of the venue that the user entered")
	public void all_results_should_match_the_criteria_of_the_venue_that_the_user_entered() {
		assertTrue(x);
	}

	@Given("I have entered city as null, price as null, date as null, guests as null")
	public void i_have_entered_city_as_null_price_as_null_date_as_null_guests_as_null() {
	    this.price = -1;
	    this.guests= -1;
	    event.setSerial(175);
}

	@Then("the result will be all the venue table content")
	public void the_result_will_be_all_the_venue_table_content() {
	    venue = new Venue();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    x = venue.refreshVenue(model, event.getCity(), event.getDate(), this.price, guests, event.getSerial());
	    assertTrue(x);
	   
	}

	private int getExpectedRowCountFromDatabase(String tableName, Map<String, Object> criteria) {
	    int expectedRowCount = 0;
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = DataBasecon.getConnection();

	        StringBuilder queryBuilder = new StringBuilder();
	        queryBuilder.append("SELECT COUNT(*) AS total_count FROM dream.").append(tableName).append(" c WHERE ");
	        List<String> conditions = new ArrayList<>();
	        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            if (value != null) {
	                if (value instanceof String) {
	                    conditions.add("c." + key + " = ?");
	                } else if (value instanceof Integer) {
	                    conditions.add("c." + key + " <= ?");
	                }
	            }
	        }
	        if (!conditions.isEmpty()) {
	            queryBuilder.append(String.join(" AND ", conditions));
	        } else {
	            queryBuilder.append("1=1");
	        }

	        statement = connection.prepareStatement(queryBuilder.toString());
	        int index = 1;
	        for (Object value : criteria.values()) {
	            if (value instanceof String || value instanceof Integer) {
	                statement.setObject(index++, value);
	            }
	        }

	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            expectedRowCount = resultSet.getInt("total_count");
	        }
	    } catch (SQLException ex) {
	    
	    } finally {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException ex) {
	          
	        }
	    }

	    return expectedRowCount;
	}

}

