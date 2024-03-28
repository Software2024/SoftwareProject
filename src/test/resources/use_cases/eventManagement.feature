
@tag
Feature: Event Management

  Background:
    Given User is signed in

  @tag1
  Scenario: Adding a new event with valid information
    When User fills bride's name as "Alice", groom's name as "Bob", budget as "5000", date as "2024-04-01", starting time as "12:00", duration as "5", guest count as "100", theme as "Vintage", and city as "Nablus"
    Then event should be created successfully  
    
    
  Scenario: Attempting to add an event that already exists
    Given An event with bride's name "Alice" and groom's name "Bob" already exists
    When User fills bride's name as "Alice", groom's name as "Bob", and other valid details
    Then User should see an error message informing that the event already exists

  Scenario: Attempting to add an event with a past date
   Given Today's date is "2024-03-01"
    When User fills event date as "2024-02-01"
    Then User should see an error message informing that the event date cannot be in the past
    
  
    
    Scenario: Edit an event with serial number 61
    When User 1234 wants to edit his event with serial number 61
    And fills valid new details 
    Then the event information should be upated
    
      
    Scenario: Deleting an event with serial number 66
    When User deletes event with serial number 66
    Then User should see a confirmation message for event deletion
