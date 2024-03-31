package softwareproject;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Component;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class testEvent {
    User user = new User();
    Event event = new Event();
    private String brideName;
    private String groomName;
    private int budget;
    private Date date1;
    private Time time;
    private int duration;
    private String theme;
    private String city;
    private int guests;
	private int ssn;
	private int serial;
	private String serviceType;
	 private int serviceNumber;
	 private int servicePrice;
	@Given("User is signed in")
    public void user_is_signed_in() {
        user = User.getInstance();
        user.setSSN(1234);
        event=Event.getInstance();
    }
    
    @When("User fills bride's name as {string}, groom's name as {string}, budget as {string}, date as {string}, starting time as {string}, duration as {string}, guest count as {string}, theme as {string}, and city as {string}")
    public void user_fills_bride_s_name_as_groom_s_name_as_budget_as_date_as_starting_time_as_duration_as_guest_count_as_theme_as_and_city_as(String brideName, String groomName, String budget, String date, String time, String duration, String guests, String theme, String city) {
        this.brideName = "brideee";
        this.groomName = "groomeee";
        this.budget = 20000;
        this.date1 = Date.valueOf("2025-03-03");
        this.time = Time.valueOf("08:30:00");
        this.duration = 2;
        this.guests = 30;
        this.theme = "vintage";
        this.city ="nablus";
        this.ssn = user.getSSN();
    }

    @Then("event should be created successfully")
    public void event_should_be_created_successfully() {
        int result = event.createEvent(ssn, brideName, groomName, budget, date1, time, duration, guests, theme, city);
        assertThat(result).isNotEqualTo(-1);
    }
   
  
    @Given("An event with bride's name {string} and groom's name {string} already exists")
    public void an_event_with_bride_s_name_and_groom_s_name_already_exists(String brideName, String groomName) {
    	String name1="bride";
    	String name2="groom";
       assertTrue(event.isEventExists(name1,name2));
    }
    @When("User fills bride's name as {string}, groom's name as {string}, and other valid details")
    public void user_fills_bride_s_name_as_groom_s_name_as_and_other_valid_details(String string, String string2) {
      
       
    }


    @Then("User should see an error message informing that the event already exists")
    public void user_should_see_an_error_message_informing_that_the_event_already_exists() {
    	  event.createEvent(ssn,"bride","groom", 2000, date1, time, 5, 100, "Vintage", "Nablus");
    	  int componentCount = JOptionPane.getRootFrame().getComponentCount();
    	  for (int i = 0; i < componentCount; i++) {
    	      Component component = JOptionPane.getRootFrame().getComponent(i);
    	      String componentName = component.getName();
    	      System.out.println("Component at index " + i + ": " + componentName);
    	  

        String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
        assertThat(errorMessage).isEqualTo("The wedding event you are trying to create already exists. Please navigate to the menu and choose manage your events to edit the event's details.");
    }
    }

    @Given("Today's date is {string}")
    public void today_s_date_is(String todayDate) {

    }
    @When("User fills event date as {string}")
    public void user_fills_event_date_as(String string) {
    	Date date=Date.valueOf("2023-03-03");
       this.date1=date;
    }

    @Then("User should see an error message informing that the event date cannot be in the past")
    public void user_should_see_an_error_message_informing_that_the_event_date_cannot_be_in_the_past() {
    	event.createEvent(ssn, groomName, brideName, budget, date1, time, duration, guests, theme, city);
    	int componentCount = JOptionPane.getRootFrame().getComponentCount();
    	for (int i = 0; i < componentCount; i++) {
    	    Component component = JOptionPane.getRootFrame().getComponent(i);
    	    String componentName = component.getName();
    	    System.out.println("Component at index " + i + ": " + componentName);
    	

        String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
        assertThat(errorMessage).isEqualTo("Error: Event date cannot be in the past.");
    }
    }


    @When("User {int} wants to edit his event with serial number {int}")
    public void user_wants_to_edit_his_event_with_serial_number(Integer userId, Integer serialNumber) {
    	this.serial = event.getSerial();
    }

    @When("fills valid new details")
    public void fills_valid_new_details() {
       this.brideName="bride";
       this.groomName = "groomeee";
       this.budget = 20000;
       this.date1 = Date.valueOf("2025-03-03");
       this.time = Time.valueOf("08:30:00");
       this.duration = 2;
       this.guests = 30;
       this.theme = "vintage";
       this.city ="nablus";
    }

    @Then("the event information should be upated")
    public void the_event_information_should_be_upated() {
      assertTrue(event.editEventInfo(this.serial,brideName,groomName,budget,date1,guests,theme,city));
    }
    @When("User deletes event with serial number {int}")
    public void user_deletes_event_with_serial_number(Integer serialNumber) {
      serial=  event.getSerial();
        event.deleteEvent(serial);
    }

    @Then("User should see a confirmation message for event deletion")
    public void user_should_see_a_confirmation_message_for_event_deletion() {
    	int componentCount = JOptionPane.getRootFrame().getComponentCount();
    	for (int i = 0; i < componentCount; i++) {
    	    Component component = JOptionPane.getRootFrame().getComponent(i);
    	    String componentName = component.getName();
    	    System.out.println("Component at index " + i + ": " + componentName);
    	

        String confirmationMessage = JOptionPane.getRootFrame().getComponent(i).getName();
        assertThat(confirmationMessage).isEqualTo("Event deleted successfully.");
    }
    }
    @Given("an event with serial number {int}")
    public void an_event_with_serial_number(Integer int1) {
      serial=event.getSerial();
    }

    @When("I add the service type\"dj\"to the event with service number {int}")
    public void i_add_the_service_type_dj_to_the_event_with_service_number(Integer int1) {
       this.serviceType="dj";
       this.serviceNumber=1;
    }

    @When("service price {int}")
    public void service_price(Integer int1) {
      this.servicePrice= event.getServicePrice(serviceType, serviceNumber);
    }

    @When("the event doesnt have a booked service type\"dj\"")
    public void the_event_doesnt_have_a_booked_service_type_dj() {
      assertFalse(event.isBooked2(serial, serviceType));
    }

    @Then("the event should be updated successfully")
    public void the_event_should_be_updated_successfully() {
       assertTrue(event.editEvent(serial, serviceNumber, serviceType, servicePrice));
    }
    @When("I delete the service type\"dj\" with number {int} from the event")
    public void i_delete_the_service_type_dj_with_number_from_the_event(Integer int1) {
    	 this.serviceType="dj";
         this.serviceNumber=1;
    }



    @When("the service type\"dj\"with number {int} is booked for event")
    public void the_service_type_dj_with_number_is_booked_for_event(Integer int1) {
        int result=(event.isBooked(serial, serviceNumber, serviceType, servicePrice));
        assertThat(result).isNotEqualTo(-1);
    }

    @Then("the service should be removed from the event successfully")
    public void the_service_should_be_removed_from_the_event_successfully() {
       assertTrue(event.deleteFromEvent(serial, serviceNumber, serviceType, servicePrice));
      
    }

}