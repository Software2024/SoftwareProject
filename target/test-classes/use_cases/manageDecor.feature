
Feature: Managing Decorations in Wedding Planning System

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

Scenario: Attempt to Edit an Existing decoration's Number to an Existing Number
    Given I intend to edit an existing decoration
    And a decoration with the same number already exists
    When I select the decoration from the list
    And I change its number to one that already exists
    Then the decoration should not be updated and I should receive a warning

Scenario: Remove an Existing decoration
    Given I want to remove an existing decoration 
    When I select the decoration from the list and click the remove button 
    Then the decoration should be removed successfully
