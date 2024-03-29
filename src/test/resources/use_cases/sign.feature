
Feature: User Authentication
@shahd
  Scenario: Successful sign-up
    Given I have chosen to sign up
    When I sign up with valid details
    Then I should be able to access the main page of the app
@shahd
  Scenario: Duplicate email
    Given I have chosen to sign up
    When I enter an email address that has already been registered
    Then I should be notified that the email already exists
@shahd
  Scenario: Invalid email format
    Given I have chosen to sign up
    When I enter an invalid email format
    Then I should be notified that the email format is invalid
@shahd
  Scenario: Short password
    Given I have chosen to sign up
    When I enter a password shorter than 8 characters
    Then I should be prompted to enter a longer password
@shahd
  Scenario: Successful log-in
    Given I have chosen to log in
    When I log in with valid details
    Then I should be able to access the main page of the app
@shahd
  Scenario: Unregistered email
    Given I have chosen to log in
    When I enter an email that is not registered
    Then I should be notified that the email isn't registered
    And I should be redirected to the sign-up page
@shahd
  Scenario: Wrong password
    Given I have chosen to log in
    When I enter a wrong password
    Then I should be notified that the password is wrong
    And I should remain on the login page


@shahd
  Scenario: Invalid email format during login
    Given I have chosen to log in
    When I enter an invalid email format
    Then I should be notified that the email format is invalid
