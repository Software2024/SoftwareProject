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
Feature: Managing Venues 

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

Scenario: Attempt to Edit an Existing Venue's Number to an Existing Number
    Given I intend to edit an existing venue
    And a venue with the same number already exists
    When I select the venue from the list
    And I change its number to one that already exists
    Then the venue should not be updated and I should receive a warning

Scenario: Remove an Existing Venue
    Given I want to remove an existing venue 
    When I select the venue from the list and click the remove button 
    Then the venue should be removed successfully
