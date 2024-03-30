
Feature: Event Management

  Background:
    Given User is signed in

 @shahd
  Scenario: Adding a new event with valid information
    When User fills bride's name as "Alice", groom's name as "Bob", budget as "5000", date as "2024-04-01", starting time as "12:00", duration as "5", guest count as "100", theme as "Vintage", and city as "Nablus"
    Then event should be created successfully  
    
    @shahd
  Scenario: Attempting to add an event that already exists
    Given An event with bride's name "Alice" and groom's name "Bob" already exists
    When User fills bride's name as "Alice", groom's name as "Bob", and other valid details
    Then User should see an error message informing that the event already exists
@shahd
  Scenario: Attempting to add an event with a past date
   Given Today's date is "2024-03-01"
    When User fills event date as "2024-02-01"
    Then User should see an error message informing that the event date cannot be in the past
    
  @shahd
    
    Scenario: Edit an event with serial number 61
    When User 1234 wants to edit his event with serial number 61
    And fills valid new details 
    Then the event information should be upated
    
    @shahd
    Scenario: add Service to my event
    Given an event with serial number 123
    When I add the service type"dj"to the event with service number 3 
    And service price 2000
    And the event doesnt have a booked service type"dj" 
    Then the event should be updated successfully
@shahd
  Scenario: Delete service from my event
    Given an event with serial number 123
    When I delete the service type"dj" with number 3 from the event
    And the service type"dj"with number 3 is booked for event
    And service price 2000
    Then the service should be removed from the event successfully
    
    @shahd  
    Scenario: Deleting an event with serial number 66
    When User deletes event with serial number 66
    Then User should see a confirmation message for event deletion

    