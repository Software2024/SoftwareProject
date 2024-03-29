package softwareProject1;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Interfacce.Budget;

import javax.swing.table.DefaultTableModel;
public class UserTest {
	 User user = new User();
	    Event event = new Event();
	    Budget Budget=new Budget();
	    DefaultTableModel  model2=(DefaultTableModel) Interfacce.Budget.jTable1.getModel();
	@Given("user is logged in")
	public void user_is_logged_in() {
	  user=User.getInstance();
	  user.setSSN(12345);
	}

	@When("user clicks the events button")
	public void user_clicks_the_events_button() {
	   
	}

	@Then("he will see his events")
	public void he_will_see_his_events() {
		 List<Object[]> eventData= user.retrieveEvents(user.getSSN(),user.isAdmin(user.getSSN()));
		 assertThat(eventData).isNotEmpty();
	}

	@Then("he will see an empty table")
	public void he_will_see_an_empty_table() {
		user.setSSN(123456);
		List<Object[]> eventData= user.retrieveEvents(user.getSSN(),user.isAdmin(user.getSSN()));
		assertThat(eventData).isEmpty();
	}

	@When("user selects an event")
	public void user_selects_an_event() {
		user.setSSN(12345);
	  event=Event.getInstance();
	  event.setSerial(57);
	}

	@When("clicks the budget button")
	public void clicks_the_budget_button() {
	  
	}

	@Then("he will see a report with his expenses")
	public void he_will_see_a_report_with_his_expenses() {
		String x=event.retrieveEventData(model2, event.getSerial());
		assertThat(x).isNotEqualTo("null");
	}

	@Then("the calender with his events dates should be not null")
	public void the_calender_with_his_events_dates_should_be_not_null() {
		 List<Object[]> events=user.retrieveEvents(user.getSSN(),user.isAdmin(user.getSSN()));
		assertThat(events).isNotEmpty();
	}

	@Given("he didnt create any events")
	public void he_didnt_create_any_events() {
		user.setSSN(123456);
	}

	@Then("the calender with his events dates should be null")
	public void the_calender_with_his_events_dates_should_be_null() {
		List<Object[]> eventData= user.retrieveEvents(user.getSSN(),user.isAdmin(user.getSSN()));
		assertThat(eventData).isEmpty();
	}
}
