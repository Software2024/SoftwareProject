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
Feature: Managing Caterers

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

Scenario: Attempt to Edit an Existing caterer's Number to an Existing Number
    Given I intend to edit an existing caterer
    And a caterer with the same number already exists
    When I select the caterer from the list
    And I change its number to one that already exists
    Then the caterer should not be updated and I should receive a warning

Scenario: Remove an Existing caterer
    Given I want to remove an existing caterer 
    When I select the caterer from the list and click the remove button 
    Then the caterer should be removed successfully
