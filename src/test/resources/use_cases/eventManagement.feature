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
Feature: Event Management

  Background:
    Given User is signed in

  @tag1
  Scenario: Adding a new event with valid information
    When User fills bride's name as "Alice", groom's name as "Bob", budget as "5000", date as "2024-04-01", starting time as "12:00", duration as "5", guest count as "100", theme as "Vintage", and city as "Nablus"
    Then event should be created successfully  
    
  Scenario: Attempting to add a new event with invalid input
    When User fills bride's name as "", groom's name as "Bob", budget as "5000", date as "2024-04-01", starting time as "12:00", duration as "5", guest count as "100", theme as "Vintage", and city as "Nablus"
    Then User should see an error message prompting to fill all the fields
    
  Scenario: Attempting to add an event that already exists
    Given An event with bride's name "Alice" and groom's name "Bob" already exists
    When User fills bride's name as "Alice", groom's name as "Bob", and other valid details
    Then User should see an error message informing that the event already exists

  Scenario: Attempting to add an event with a past date
   Given Today's date is "2024-03-01"
    When User fills bride's name as "Alice", groom's name as "Bob", event date as "2024-02-01", and other valid details
    Then User should see an error message informing that the event date cannot be in the past
    
    
    Scenario: Deleting an event with serial number 2
    When User deletes event with serial number 2
    Then User should see a confirmation message for event deletion
