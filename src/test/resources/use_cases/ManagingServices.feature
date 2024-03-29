
Feature: Managing Services

Scenario: Add a New Venue
    Given I intend to add a new venue
    When I provide the venue details
    Then the venue should be added successfully

Scenario: Attempt to Add a Venue with Missing Information
    Given I want to add a new venue
    When I provide incomplete venue details
    Then I should receive a warning that fields cannot be left empty

Scenario: Attempt to Add a Venue That Already Exists
    Given a venue with the same number already exists
    When I attempt to add the venue
    Then I should receive a warning that the venue was already added

Scenario: Edit an Existing Venue
    Given I intend to edit an existing venue
    When I select the venue from the list
    And I provide the updated venue details
    Then the venue should be successfully updated

Scenario: Remove an Existing Venue
    Given I want to remove an existing venue 
    When I select the venue from the list and click the remove button 
    Then the venue should be removed successfully
    
Scenario: Add a New studio
    Given I intend to add a new studio
    When I provide the studio details
    Then the studio should be added successfully

Scenario: Attempt to Add a studio with Missing Information
    Given I want to add a new studio
    When I provide incomplete studio details
    Then I should receive a warning that fields cannot be left empty

Scenario: Attempt to Add a studio That Already Exists
    Given a studio with the same number already exists
    When I attempt to add the studio
    Then I should receive a warning that the studio was already added

Scenario: Edit an Existing studio
    Given I intend to edit an existing studio
    When I select the studio from the list
    And I provide the updated studio details
    Then the studio should be successfully updated

Scenario: Remove an Existing studio
    Given I want to remove an existing studio 
    When I select the studio from the list and click the remove button 
    Then the studio should be removed successfully
    
    Scenario: Add a New dj
    Given I intend to add a new dj
    When I provide the dj details
    Then the dj should be added successfully

Scenario: Attempt to Add a dj with Missing Information
    Given I want to add a new dj
    When I provide incomplete dj details
    Then I should receive a warning that fields cannot be left empty

Scenario: Attempt to Add a dj That Already Exists
    Given a dj with the same number already exists
    When I attempt to add the dj
    Then I should receive a warning that the dj was already added

Scenario: Edit an Existing dj
    Given I intend to edit an existing dj
    When I select the dj from the list
    And I provide the updated dj details
    Then the dj should be successfully updated

Scenario: Remove an Existing dj
    Given I want to remove an existing dj 
    When I select the dj from the list and click the remove button 
    Then the dj should be removed successfully
    
     Scenario: Add a New decoration
    Given I intend to add a new decoration
    When I provide the decoration details
    Then the decoration should be added successfully

Scenario: Attempt to Add a decoration with Missing Information
    Given I want to add a new decoration
    When I provide incomplete decoration details
    Then I should receive a warning that fields cannot be left empty

Scenario: Attempt to Add a decoration That Already Exists
    Given a decoration with the same number already exists
    When I attempt to add the decoration
    Then I should receive a warning that the decoration was already added

Scenario: Edit an Existing decoration
    Given I intend to edit an existing decoration
    When I select the decoration from the list
    And I provide the updated decoration details
    Then the decoration should be successfully updated

Scenario: Remove an Existing decoration
    Given I want to remove an existing decoration 
    When I select the decoration from the list and click the remove button 
    Then the decoration should be removed successfully
     Scenario: Add a New caterer
    Given I intend to add a new caterer
    When I provide the caterer details
    Then the caterer should be added successfully

Scenario: Attempt to Add a caterer with Missing Information
    Given I want to add a new caterer
    When I provide incomplete caterer details
    Then I should receive a warning that fields cannot be left empty

Scenario: Attempt to Add a caterer That Already Exists
    Given a caterer with the same number already exists
    When I attempt to add the caterer
    Then I should receive a warning that the caterer was already added

Scenario: Edit an Existing caterer
    Given I intend to edit an existing caterer
    When I select the caterer from the list
    And I provide the updated caterer details
    Then the caterer should be successfully updated

Scenario: Remove an Existing caterer
    Given I want to remove an existing caterer 
    When I select the caterer from the list and click the remove button 
    Then the caterer should be removed successfully
    
    
