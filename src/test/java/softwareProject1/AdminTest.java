package softwareProject1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdminTest {
User  user=new User();
private int selectedIndex;
private int userssn;

	@Given("admin is logged in the system")
	public void admin_is_logged_in_the_system() {
		user=User.getInstance();
	   user.setSSN(1234);
	   assertTrue(user.isAdmin(user.getSSN()));
	   
	}

	@Given("admin wants to view events")
	public void admin_wants_to_view_events() {
	}

	@Then("events are populated in table")
	public void events_are_populated_in_table() {
		 List<Object[]> eventData= user.retrieveEvents(user.getSSN(),user.isAdmin(user.getSSN()));
		 assertThat(eventData).isNotEmpty();		 
	}

	@Given(": admin is on user page")
	public void admin_is_on_user_page() {
	    
	}

	@Given(": the user index has been selected")
	public void the_user_index_has_been_selected() {
	  selectedIndex = 2;
	  userssn = 3456;
	}

	@Then(":the user with ssn {int} should be deleted")
	public void the_user_with_ssn_should_be_deleted(Integer int1) throws SQLException {
		
	    assertTrue(user.removeUser(selectedIndex,userssn));
	}

}
