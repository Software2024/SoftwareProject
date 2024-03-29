
Feature: user operations
  Background:
  Given user is logged in

  @shahd
  Scenario: user wants to see events he created and he have created events
    When user clicks the events button
    Then he will see his events
    @shahd
    Scenario: user wants to see events he created and he have not created events
    When user clicks the events button
    Then he will see an empty table 
    @shahd
    Scenario: user is on events page 
     When user selects an event
    And  clicks the budget button
    Then he will see a report with his expenses
    @shahd
 
    Scenario: user is on menu page 
    When: user selects calender button
    Then the calender with his events dates should be not null 
 @shahd
  Scenario: user is on menu page 
    When: user selects calender button
    And he didnt create any events
    Then the calender with his events dates should be null
 