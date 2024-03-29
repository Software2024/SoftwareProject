

Feature: admin operations
 Background:
 Given admin is logged in the system
  @shahd
  Scenario: view events in system
    Given admin wants to view events
    Then events are populated in table
    
    @shahd
    Scenario: delete user 
    Given : admin is on user page
    And : the user index has been selected
    Then :the user with ssn 1234 should be deleted

   