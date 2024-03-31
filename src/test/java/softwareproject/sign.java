package softwareproject;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.Component;
import javax.swing.JOptionPane;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class sign {
	 User user = new User();
	 private int ssn;
	 private String first_name;
	 private String last_name;
	 private String email;
	 private String password; 
	 private int phone_number;

	 @Given("I have chosen to sign up")
	public void i_have_chosen_to_sign_up() {
	   
	}

	@When("I sign up with valid details")
	public void i_sign_up_with_valid_details() {
	  this.email="test@gmail.com";
	  this.password="12345678";
	  this.first_name="ahmad";
	  this.last_name="mallah";
	  this.phone_number=90909999;
	  this.ssn=3456;
	 user= User.getInstance();
	   assertTrue(user.isValidEmail(email));
	   assertTrue(user.isPasswordLongEnough(password));
	   assertTrue(user.signUp(ssn, first_name, last_name, email, password, phone_number));
	}

	@Then("I should be able to access the main page of the app")
	public void i_should_be_able_to_access_the_main_page_of_the_app() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("Welcome.");
   }
	  
	}

	@When("I enter an email address that has already been registered")
	public void i_enter_an_email_address_that_has_already_been_registered() {
	   this.email="shahdfgh@gmail.com";
	   assertTrue(user.isEmailAlreadyRegistered(email,"dream.user"));
	}

	@Then("I should be notified that the email already exists")
	public void i_should_be_notified_that_the_email_already_exists() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("Email already has an account. Please use a different email.");
   }
	}

	@When("I enter an invalid email format")
	public void iEnterAnInvalidEmailFormat() {
		 this.email="123";
		 assertFalse(user.isValidEmail(email));
	  
	}

	

	@Then("I should be notified that the email format is invalid")
	public void i_should_be_notified_that_the_email_format_is_invalid() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("the email address is not valid.");
   }
	}

	

	@When("I enter a password shorter than {int} characters")
	public void i_enter_a_password_shorter_than_characters(Integer int1) {
	  this.password="";
	  assertFalse(user.isPasswordLongEnough(password));
	}

	@Then("I should be prompted to enter a longer password")
	public void i_should_be_prompted_to_enter_a_longer_password() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("the password should be 8 characters or more.");
   }
	}

	@Given("I have chosen to log in")
	public void iHaveChosenToLogIn() {
	   
	}

	@When("I log in with valid details")
	public void i_log_in_with_valid_details() {
	   this.email="shahdfgh@gmail.com";
	   this.password="12345678";
	   assertTrue(user.logIn(email, password,"dream.user"));
	}

	@When("I enter an email that is not registered")
	public void i_enter_an_email_that_is_not_registered() {
	   this.email="shahdisnot@gmail.com";
	   assertFalse(user.isEmailAlreadyRegistered(email,"dream.user"));
	}

	@Then("I should be notified that the email isn't registered")
	public void i_should_be_notified_that_the_email_isn_t_registered() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("Email not registered. Please sign up.");
   }
	}

	@Then("I should be redirected to the sign-up page")
	public void i_should_be_redirected_to_the_sign_up_page() {
	   
	}

	@When("I enter a wrong password")
	public void i_enter_a_wrong_password() {
	  this.email="shahdfgh@gmail.com";
	  this.password="1234";
	  assertFalse(user.logIn(email, password,"dream.user"));
	}

	@Then("I should be notified that the password is wrong")
	public void i_should_be_notified_that_the_password_is_wrong() {
		 int componentCount = JOptionPane.getRootFrame().getComponentCount();
   	  for (int i = 0; i < componentCount; i++) {
   	      Component component = JOptionPane.getRootFrame().getComponent(i);
   	      String componentName = component.getName();
   	      System.out.println("Component at index " + i + ": " + componentName);
   	  

       String errorMessage = JOptionPane.getRootFrame().getComponent(i).getName();
       assertThat(errorMessage).isEqualTo("Incorrect password. Please try again.");
   }
	}

	@Then("I should remain on the login page")
	public void i_should_remain_on_the_login_page() {
	  
	}

}
