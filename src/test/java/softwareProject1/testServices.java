package softwareProject1;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testServices {
	venue Venue;
	studio Studio;
	dj Dj;
	cater Cater;
	decoration Decor;
    
	@Given("I intend to add a new venue")
	public void i_intend_to_add_a_new_venue() {
	    Venue = new venue();
	    
	}

	@When("I provide the venue details")
	public void i_provide_the_venue_details() {
	    Venue.setNumber(10);
	    Venue.setName("Queens");
	    Venue.setPrice(1500);
	    Venue.setCapacity(500);
	    Venue.setLocation("Deir Sharaf");
	    Venue.setDescription("Big and cozy");	
	    Venue.setCity("nablus");
	  
	}

	@Then("the venue should be added successfully")
	public void the_venue_should_be_added_successfully() throws SQLException {
		 Venue.setNumber(10);
		    Venue.setName("Queens");
		    Venue.setPrice(1500);
		    Venue.setCapacity(500);
		    Venue.setLocation("Deir Sharaf");
		    Venue.setDescription("Big and cozy");	
		    Venue.setCity("nablus");
	 assertTrue(Venue.addVenue(Venue.getNumber(), Venue.getName(), Venue.getPrice(), Venue.getCapacity(), Venue.getCity(),Venue.getLocation(), Venue.getDescription()));
	  
	}

	@Given("I want to add a new venue")
	public void i_want_to_add_a_new_venue() {
	   Venue = new venue();
	   
	}

	@When("I provide incomplete venue details")
	public void i_provide_incomplete_venue_details() {
		 Venue.setNumber(10);
		    Venue.setName(null);
		    Venue.setPrice(1500);
		    Venue.setCapacity(-1);
		    Venue.setLocation("Deir Sharaf");
		    Venue.setDescription("Big and cozy");	  
		    Venue.setCity("Nablus");
		    assertTrue(Venue.areTheFieldsNull(Venue.getNumber(), Venue.getName(), Venue.getPrice(), Venue.getCapacity(), Venue.getLocation(),Venue.getDescription(), Venue.getCity()));
	  
	}

	@Then("I should receive a warning that fields cannot be left empty")
	public void i_should_receive_a_warning_that_fields_cannot_be_left_empty() throws SQLException {
		Venue.addVenue(Venue.getNumber(), Venue.getName(), Venue.getPrice(), Venue.getCapacity(),Venue.getCity(), Venue.getLocation(),Venue.getDescription());
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	      
   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(warningMessage).isEqualTo("You can't leave any of the fields empty!");
   	  }
	   
	}

	@Given("a venue with the same number already exists")
	public void a_venue_with_the_same_number_already_exists() throws SQLException {
		Venue = new venue();
		  Venue.setNumber(10);
		    Venue.setName("NewJersy");
		    Venue.setPrice(2500);
		    Venue.setCapacity(200);
		    Venue.setLocation("Rafidya");
		    Venue.setDescription("Good");
		    Venue.setCity("nablus");
		    assertTrue(Venue.venueAlreadyAdded(Venue.getNumber()));
	    
	}

	@When("I attempt to add the venue")
	public void i_attempt_to_add_the_venue() throws SQLException {
		Venue.addVenue(Venue.getNumber(), Venue.getName(), Venue.getPrice(), Venue.getCapacity(),Venue.getCity(), Venue.getLocation(),Venue.getDescription());
	   
	}

	@Then("I should receive a warning that the venue was already added")
	public void i_should_receive_a_warning_that_the_venue_was_already_added() throws SQLException {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	   	  for (int i = 0; i < componentCount; i++) {
	   	      Component component = JOptionPane.getRootFrame().getComponent(i);
	   	      String componentName = component.getName();
	   	      System.out.println("Component at index " + i + ": " + componentName);
	   	      
	   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	       assertThat(warningMessage).isEqualTo("This venue was already added");
	   	  }
	}

	@Given("I intend to edit an existing venue")
	public void i_intend_to_edit_an_existing_venue() {
		Venue = new venue();
	}

	@When("I select the venue from the list")
	public void i_select_the_venue_from_the_list() {
	   Venue.setNumber(10);
	   
	}

	@When("I provide the updated venue details")
	public void i_provide_the_updated_venue_details() {
      Venue.setName("Hawaii");
      Venue.setPrice(2000);
      Venue.setCapacity(200);
      Venue.setLocation("Al rayhan");
      Venue.setDescription("Garden");
      Venue.setCity("Ramallah");
	    
	}

	@Then("the venue should be successfully updated")
	public void the_venue_should_be_successfully_updated() throws SQLException {
	   assertTrue(Venue.editVenue(Venue.getName(), Venue.getPrice(), Venue.getCapacity(), Venue.getLocation(),Venue.getCity(),Venue.getDescription(), Venue.getNumber()));
	  
	}

	@Given("I want to remove an existing venue")
	public void i_want_to_remove_an_existing_venue() {
		Venue = new venue();
	}

	@When("I select the venue from the list and click the remove button")
	public void i_select_the_venue_from_the_list_and_click_the_remove_button() {
	   Venue.setNumber(10);
	   
	}

	@Then("the venue should be removed successfully")
	public void the_venue_should_be_removed_successfully() throws SQLException {
	 assertTrue( Venue.removeVenue(1, Venue.getNumber()));
	  
	}

	@Given("I intend to add a new studio")
	public void i_intend_to_add_a_new_studio() {
		 Studio = new studio();
	 
	}

	@When("I provide the studio details")
	public void i_provide_the_studio_details() {
		 Studio.setNumber(10);
	     Studio.setName("Hanini Studio");
	     Studio.setPrice(1500);
	     Studio.setCity("nablus");
	     Studio.setPackage1("Film");
	   
	}

	@Then("the studio should be added successfully")
	public void the_studio_should_be_added_successfully() throws HeadlessException, SQLException {
		assertTrue( Studio.addStudio(Studio.getNumber(), Studio.getName(), Studio.getPrice(), Studio.getCity(), Studio.getPackage1()));
	   
	}

	@Given("I want to add a new studio")
	public void i_want_to_add_a_new_studio() {
	    Studio = new studio();
	 
	}

	@When("I provide incomplete studio details")
	public void i_provide_incomplete_studio_details() throws HeadlessException, SQLException {
		  Studio.setNumber(12); 
	      Studio.setName(null);
	      Studio.setPrice(1500);
	      Studio.setCity(null);
	      Studio.setPackage1("Film");
	     assertTrue(Studio.areTheFieldsNull(Studio.getNumber(), Studio.getName(), Studio.getPrice(), Studio.getCity(), Studio.getPackage1()));
	   
	}
	@Then("I should receive a warning that studio fields cannot be left empty")
	public void i_should_receive_a_warning_that_studio_fields_cannot_be_left_empty() {
		Studio.addStudio(Studio.getNumber(), Studio.getName(), Studio.getPrice(), Studio.getCity(), Studio.getPackage1());
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
  	  for (int i = 0; i < componentCount; i++) {
  	      Component component = JOptionPane.getRootFrame().getComponent(i);
  	      String componentName = component.getName();
  	      System.out.println("Component at index " + i + ": " + componentName);
  	      
  	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
      assertThat(warningMessage).isEqualTo("You can't leave any of the fields empty!");
  	  }
	}

	@Given("a studio with the same number already exists")
	public void a_studio_with_the_same_number_already_exists() throws SQLException {
		  Studio = new studio();  
		Studio.setNumber(10); 
	      Studio.setName("Zaina");
	      Studio.setPrice(1500);
	      Studio.setCity("nablus");
	      Studio.setPackage1("film");
	      assertTrue(Studio.studioAlreadyAdded(Studio.getNumber()));
	   
	}

	@When("I attempt to add the studio")
	public void i_attempt_to_add_the_studio() {
		 Studio.addStudio(Studio.getNumber(), Studio.getName(), Studio.getPrice(), Studio.getCity(), Studio.getPackage1());
	    
	}

	@Then("I should receive a warning that the studio was already added")
	public void i_should_receive_a_warning_that_the_studio_was_already_added() throws HeadlessException, SQLException {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	   	  for (int i = 0; i < componentCount; i++) {
	   	      Component component = JOptionPane.getRootFrame().getComponent(i);
	   	      String componentName = component.getName();
	   	      System.out.println("Component at index " + i + ": " + componentName);
	   	      
	   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	       assertThat(warningMessage).isEqualTo("This studio was already added");
	   	  }

		 
	   
	}

	@Given("I intend to edit an existing studio")
	public void i_intend_to_edit_an_existing_studio() {
		  Studio = new studio();
	}

	@When("I select the studio from the list")
	public void i_select_the_studio_from_the_list() {
	    Studio.setNumber(10);
	}

	@When("I provide the updated studio details")
	public void i_provide_the_updated_studio_details() {
		   Studio.setName("Layan");
		   Studio.setPrice(2500);
		   Studio.setCity("nablus");
		   Studio.setPackage1("film");
	   
	}

	@Then("the studio should be successfully updated")
	public void the_studio_should_be_successfully_updated() {
	  assertTrue(  Studio.editStudio(Studio.getNumber(), Studio.getName(), Studio.getPrice(), Studio.getCity(), Studio.getPackage1()));
	  
	}

	@Given("I want to remove an existing studio")
	public void i_want_to_remove_an_existing_studio() {
		  Studio = new studio();
	  
	}

	@When("I select the studio from the list and click the remove button")
	public void i_select_the_studio_from_the_list_and_click_the_remove_button() {
	    Studio.setNumber(10);
	   
	}

	@Then("the studio should be removed successfully")
	public void the_studio_should_be_removed_successfully() throws SQLException {
	  assertTrue(  Studio.removeStudio(1, Studio.getNumber()));
	  
	}

	@Given("I intend to add a new dj")
	public void i_intend_to_add_a_new_dj() {
		Dj = new dj();
	  
	}

	@When("I provide the dj details")
	public void i_provide_the_dj_details() {
		  Dj.setNumber(10);
	      Dj.setName("Zaina");
	      Dj.setPrice(150);
	    Dj.setCity("Jenin");
	  
	}

	@Then("the dj should be added successfully")
	public void the_dj_should_be_added_successfully() throws HeadlessException, SQLException {
		assertTrue(Dj.addDj(Dj.getNumber(), Dj.getName(), Dj.getPrice(), Dj.getCity()));
	  
	}

	@Given("I want to add a new dj")
	public void i_want_to_add_a_new_dj() {
		Dj = new dj();
	
	}

	@When("I provide incomplete dj details")
	public void i_provide_incomplete_dj_details() throws HeadlessException, SQLException {
		Dj.setNumber(11); 
        Dj.setName(null);
        Dj.setPrice(15000); 
        Dj.setCity(null);
      assertTrue(Dj.areTheFieldsNull(Dj.getNumber(), Dj.getName(), Dj.getPrice(), Dj.getCity()));
	   
	}
	@Then("I should receive a warning that dj fields cannot be left empty")
	public void i_should_receive_a_warning_that_dj_fields_cannot_be_left_empty() throws HeadlessException, SQLException {
		Dj.addDj(Dj.getNumber(), Dj.getName(), Dj.getPrice(), Dj.getCity());
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	  	  for (int i = 0; i < componentCount; i++) {
	  	      Component component = JOptionPane.getRootFrame().getComponent(i);
	  	      String componentName = component.getName();
	  	      System.out.println("Component at index " + i + ": " + componentName);
	  	      
	  	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	      assertThat(warningMessage).isEqualTo("You can't leave any of the fields empty!");
	  	  }
	}


	@Given("a dj with the same number already exists")
	public void a_dj_with_the_same_number_already_exists() throws SQLException {
		Dj = new dj();
		Dj.setNumber(1);
	      Dj.setName("Zaina");
	      Dj.setPrice(150);
	      Dj.setCity("ramallah");
	      assertTrue(Dj.djAlreadyAdded(Dj.getNumber()));
	    
	}

	@When("I attempt to add the dj")
	public void i_attempt_to_add_the_dj() throws HeadlessException, SQLException {
		Dj.addDj(Dj.getNumber(), Dj.getName(), Dj.getPrice(), Dj.getCity());
	   
	}

	@Then("I should receive a warning that the dj was already added")
	public void i_should_receive_a_warning_that_the_dj_was_already_added() throws HeadlessException, SQLException {
		int componentCount = JOptionPane.getRootFrame().getComponentCount();
	   	  for (int i = 0; i < componentCount; i++) {
	   	      Component component = JOptionPane.getRootFrame().getComponent(i);
	   	      String componentName = component.getName();
	   	      System.out.println("Component at index " + i + ": " + componentName);
	   	      
	   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	       assertThat(warningMessage).isEqualTo("This dj was already added");
	   	  }

	   
	}

	@Given("I intend to edit an existing dj")
	public void i_intend_to_edit_an_existing_dj() {
	 
		Dj = new dj();
	}

	@When("I select the dj from the list")
	public void i_select_the_dj_from_the_list() {
	   Dj.setNumber(10);
	   
	}

	@When("I provide the updated dj details")
	public void i_provide_the_updated_dj_details() {
		
        Dj.setName("WOW");
        Dj.setPrice(1500); 
        Dj.setCity("ramallah");
   
	}

	@Then("the dj should be successfully updated")
	public void the_dj_should_be_successfully_updated() {
	  assertTrue( Dj.editDj(Dj.getNumber(), Dj.getName(), Dj.getPrice(),Dj.getCity()));
	    
	}

	@Given("I want to remove an existing dj")
	public void i_want_to_remove_an_existing_dj() {
		Dj = new dj();
	}

	@When("I select the dj from the list and click the remove button")
	public void i_select_the_dj_from_the_list_and_click_the_remove_button() {
	   Dj.setNumber(10);
	    
	}

	@Then("the dj should be removed successfully")
	public void the_dj_should_be_removed_successfully() {
	  assertTrue( Dj.removeDj(1, Dj.getNumber()));
	  
	}

	@Given("I intend to add a new decoration")
	public void i_intend_to_add_a_new_decoration() {
	   Decor = new decoration();
	 
	}

	@When("I provide the decoration details")
	public void i_provide_the_decoration_details() {
	    Decor.setNumber(10);
	    Decor.setName("Party");
	    Decor.setPrice(500);
	    Decor.setTheme("Floral");
	    Decor.setCity("nablus");
	  
	}

	@Then("the decoration should be added successfully")
	public void the_decoration_should_be_added_successfully() throws HeadlessException, SQLException {
	   assertTrue( Decor.addDecorations(Decor.getNumber(), Decor.getName(), Decor.getPrice(), Decor.getTheme(), Decor.getCity()));
	   
	}

	@Given("I want to add a new decoration")
	public void i_want_to_add_a_new_decoration() {
		Decor = new decoration();
	   
	}

	@When("I provide incomplete decoration details")
	public void i_provide_incomplete_decoration_details() throws HeadlessException, SQLException {
		Decor.setNumber(11);
	    Decor.setName(null);
	    Decor.setPrice(500);
	    Decor.setTheme("Floral");
	    Decor.setCity("nablus");
	  assertTrue(Decor.areTheFieldsNull(Decor.getNumber(), Decor.getName(), Decor.getPrice(), Decor.getTheme(), Decor.getCity()));
	   
	}
	@Then("I should receive a warning that decoration fields cannot be left empty")
	public void i_should_receive_a_warning_that_decoration_fields_cannot_be_left_empty() throws HeadlessException, SQLException {
		 Decor.addDecorations(Decor.getNumber(), Decor.getName(), Decor.getPrice(), Decor.getTheme(), Decor.getCity());
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	  	  for (int i = 0; i < componentCount; i++) {
	  	      Component component = JOptionPane.getRootFrame().getComponent(i);
	  	      String componentName = component.getName();
	  	      System.out.println("Component at index " + i + ": " + componentName);
	  	      
	  	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	      assertThat(warningMessage).isEqualTo("You can't leave any of the fields empty!");
	  	  }
	}

	@Given("a decoration with the same number already exists")
	public void a_decoration_with_the_same_number_already_exists() throws SQLException {
		Decor = new decoration();
		 Decor.setNumber(10);
		    Decor.setName("Party");
		    Decor.setPrice(500);
		    Decor.setTheme("Floral");
		    Decor.setCity("tullkarm");
		    assertTrue(Decor.decorationAlreadyAdded(Decor.getNumber()));
	    
	}

	@When("I attempt to add the decoration")
	public void i_attempt_to_add_the_decoration() throws HeadlessException, SQLException {
		Decor.addDecorations(Decor.getNumber(), Decor.getName(), Decor.getPrice(), Decor.getTheme(), Decor.getCity());
	  
	}

	@Then("I should receive a warning that the decoration was already added")
	public void i_should_receive_a_warning_that_the_decoration_was_already_added() throws HeadlessException, SQLException {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	   	  for (int i = 0; i < componentCount; i++) {
	   	      Component component = JOptionPane.getRootFrame().getComponent(i);
	   	      String componentName = component.getName();
	   	      System.out.println("Component at index " + i + ": " + componentName);
	   	      
	   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	       assertThat(warningMessage).isEqualTo("This decoration was already added");
	   	  }

	   
	}

	@Given("I intend to edit an existing decoration")
	public void i_intend_to_edit_an_existing_decoration() {
		Decor = new decoration();
	}

	@When("I select the decoration from the list")
	public void i_select_the_decoration_from_the_list() {
	Decor.setNumber(10);
	   
	}

	@When("I provide the updated decoration details")
	public void i_provide_the_updated_decoration_details() {
		Decor.setName("Party");
	    Decor.setPrice(500);
	    Decor.setTheme("Floral");
	    Decor.setCity("nablus");
	   
	}

	@Then("the decoration should be successfully updated")
	public void the_decoration_should_be_successfully_updated() {
	  assertTrue(  Decor.editDecoration(Decor.getNumber(), Decor.getName(), Decor.getPrice(), Decor.getTheme(), Decor.getCity()));
	   
	}

	@Given("I want to remove an existing decoration")
	public void i_want_to_remove_an_existing_decoration() {
		Decor = new decoration();
	}

	@When("I select the decoration from the list and click the remove button")
	public void i_select_the_decoration_from_the_list_and_click_the_remove_button() {
	    Decor.setNumber(10);
	  
	}

	@Then("the decoration should be removed successfully")
	public void the_decoration_should_be_removed_successfully() {
		 Decor.removeDecoration(1, Decor.getNumber());
	   
	}

	@Given("I intend to add a new caterer")
	public void i_intend_to_add_a_new_caterer() {
	    Cater = new cater();
	    
	}

	@When("I provide the caterer details")
	public void i_provide_the_caterer_details() {
	    Cater.setNumber(10);
        Cater.setName("CakenBake");
        Cater.setPrice(1500);
        Cater.setPackage("Cake");
        Cater.setCity("nablus");
	  
	}

	@Then("the caterer should be added successfully")
	public void the_caterer_should_be_added_successfully() throws HeadlessException, SQLException {
	   assertTrue( Cater.addCater(Cater.getNumber(), Cater.getName(),Cater.getPrice(), Cater.getPackage(), Cater.getCity()));
	  
	}

	@Given("I want to add a new caterer")
	public void i_want_to_add_a_new_caterer() {
		Cater = new cater();
	   
	}

	@When("I provide incomplete caterer details")
	public void i_provide_incomplete_caterer_details() throws HeadlessException, SQLException {
        Cater.setNumber(2); 
        Cater.setName(null);
        Cater.setPrice(1500);
        Cater.setPackage("Cupcake"); 
        Cater.setCity(null);
       assertTrue(Cater.areTheFieldsNull(Cater.getNumber(), Cater.getName(),Cater.getPrice(), Cater.getPackage(), Cater.getCity()));
	   
	}
	@Then("I should receive a warning that caterer fields cannot be left empty")
	public void i_should_receive_a_warning_that_caterer_fields_cannot_be_left_empty() {
		Cater.addCater(Cater.getNumber(), Cater.getName(),Cater.getPrice(), Cater.getPackage(), Cater.getCity());
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	  	  for (int i = 0; i < componentCount; i++) {
	  	      Component component = JOptionPane.getRootFrame().getComponent(i);
	  	      String componentName = component.getName();
	  	      System.out.println("Component at index " + i + ": " + componentName);
	  	      
	  	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	      assertThat(warningMessage).isEqualTo("You can't leave any of the fields empty!");
	  	  }
	}


	@Given("a caterer with the same number already exists")
	public void a_caterer_with_the_same_number_already_exists() throws SQLException {
		Cater = new cater();
		 Cater.setNumber(10); 
	     Cater.setName("Lebanon");
	     Cater.setPrice(1500);
	     Cater.setPackage("Cup cakes"); 
	    Cater.setCity("nablus");
	    assertTrue(Cater.caterAlreadyAdded(Cater.getNumber()));
	    
	}

	@When("I attempt to add the caterer")
	public void i_attempt_to_add_the_caterer() {
		 Cater.addCater(Cater.getNumber(), Cater.getName(),Cater.getPrice(), Cater.getPackage(), Cater.getCity());
	   
	}

	@Then("I should receive a warning that the caterer was already added")
	public void i_should_receive_a_warning_that_the_caterer_was_already_added() throws HeadlessException, SQLException {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
	   	  for (int i = 0; i < componentCount; i++) {
	   	      Component component = JOptionPane.getRootFrame().getComponent(i);
	   	      String componentName = component.getName();
	   	      System.out.println("Component at index " + i + ": " + componentName);
	   	      
	   	   String warningMessage = JOptionPane.getRootFrame().getComponent(i).getName();
	       assertThat(warningMessage).isEqualTo("This caterer was already added");
	   	  }

	   
	}

	@Given("I intend to edit an existing caterer")
	public void i_intend_to_edit_an_existing_caterer() {
	    
		Cater = new cater();
	}

	@When("I select the caterer from the list")
	public void i_select_the_caterer_from_the_list() {
	  Cater.setNumber(10);
	   
	}

	@When("I provide the updated caterer details")
	public void i_provide_the_updated_caterer_details() {
		   Cater.setName("Lebanon Cake");
		     Cater.setPrice(1000);
		     Cater.setPackage("Cup cakes"); 
		     Cater.setCity("jenin");
	   
	}

	@Then("the caterer should be successfully updated")
	public void the_caterer_should_be_successfully_updated() {
	  assertTrue( Cater.editCater(Cater.getNumber(), Cater.getName(),Cater.getPrice(), Cater.getPackage(), Cater.getCity()));
	   
	}

	@Given("I want to remove an existing caterer")
	public void i_want_to_remove_an_existing_caterer() {
		Cater = new cater();
	}

	@When("I select the caterer from the list and click the remove button")
	public void i_select_the_caterer_from_the_list_and_click_the_remove_button() {
	   Cater.setNumber(10);
	   
	}

	@Then("the caterer should be removed successfully")
	public void the_caterer_should_be_removed_successfully() {
	 assertTrue( Cater.removeCater(1, Cater.getNumber()));
	   
	}
}

