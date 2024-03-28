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
Feature: Managing Photography and Video StudiosSystem

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

Scenario: Attempt to Edit an Existing studio's Number to an Existing Number
    Given I intend to edit an existing studio
    And a studio with the same number already exists
    When I select the studio from the list
    And I change its number to one that already exists
    Then the studio should not be updated and I should receive a warning

Scenario: Remove an Existing studio
    Given I want to remove an existing studio 
    When I select the studio from the list and click the remove button 
    Then the studio should be removed successfully
