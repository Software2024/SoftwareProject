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
Feature: Managing DJs 

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

Scenario: Attempt to Edit an Existing dj's Number to an Existing Number
    Given I intend to edit an existing dj
    And a dj with the same number already exists
    When I select the dj from the list
    And I change its number to one that already exists
    Then the dj should not be updated and I should receive a warning

Scenario: Remove an Existing dj
    Given I want to remove an existing dj 
    When I select the dj from the list and click the remove button 
    Then the dj should be removed successfully
