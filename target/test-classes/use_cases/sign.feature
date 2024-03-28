#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: User Authentication

  Scenario: Successful sign-up
    Given I have chosen to sign up
    When I sign up with valid details
    Then I should be able to access the main page of the app

  Scenario: Duplicate email
    Given I have chosen to sign up
    When I enter an email address that has already been registered
    Then I should be notified that the email already exists

  Scenario: Invalid email format
    Given I have chosen to sign up
    When I enter an invalid email format
    Then I should be notified that the email format is invalid

  Scenario: Null email or password
    Given I have chosen to sign up
    When I leave the email or the password field empty
    Then I should be prompted to enter the email/password

  Scenario: Short password
    Given I have chosen to sign up
    When I enter a password shorter than 8 characters
    Then I should be prompted to enter a longer password

  Scenario: Successful log-in
    Given I have chosen to log in
    When I log in with valid details
    Then I should be able to access the main page of the app

  Scenario: Unregistered email
    Given I have chosen to log in
    When I enter an email that is not registered
    Then I should be notified that the email isn't registered
    And I should be redirected to the sign-up page

  Scenario: Wrong password
    Given I have chosen to log in
    When I enter a wrong password
    Then I should be notified that the password is wrong
    And I should remain on the login page

  Scenario: Forgot Password
    Given I am on the login page
    And I see a "Forgot Your Password" link
    When I click on the "Forgot Your Password" link
    Then I should be directed to the forgot password page
    And I should see a form to enter my email
    When I enter my email
    Then I should receive an email with instructions to reset my password
    And I should be redirected to a page confirming that the instructions have been sent

  Scenario: Null email or password during login
    Given I have chosen to log in
    When I leave the email or the password field empty
    Then I should be prompted to enter the email/password

  Scenario: Invalid email format during login
    Given I have chosen to log in
    When I enter an invalid email format
    Then I should be notified that the email format is invalid
