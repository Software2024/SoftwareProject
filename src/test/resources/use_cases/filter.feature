
Feature: Filtering the services

Background:
  Given I have a table "decoration table"
  And I have a table "dj table"
  And I have a table "studio table"
  And I have a table "cater table"
  And I have a table "venue table"
@shahd
Scenario: Filtering decoration to the user's selection
  Given I have entered city as "nablus", theme as "Vintage", price as 2323, date as "2024-06-9"
  When the table is displayed
  Then all results should match the criteria of the decoration that the user entered
@shahd
Scenario: Filtering decoration to the user's null selection
  Given I have entered city as null, theme as null, price as null, date as null
  When the table is displayed
  Then the result will be all the decoration table content
@shahd
Scenario: Filtering dj to the user's selection
  Given I have entered city as "nablus", price as 2323, date as "2024-06-9"
  When the dj table is displayed
  Then all results should match the criteria of the dj that the user entered
@shahd
Scenario: Filtering dj to the user's null selection
  Given I have entered city as null, price as null, date as null
  When the dj table is displayed
  Then the result will be all the dj table content
@shahd
Scenario: Filtering studio to the user's selection
  Given I have entered city as "nablus", price as 2323, date as "2024-06-9"
  When the studio table is displayed
  Then all results should match the criteria of the studio that the user entered
@shahd
Scenario: Filtering studio to the user's null selection
  Given I have entered city as null, price as null, date as null
  When the studio table is displayed
  Then the result will be all the studio table content
@shahd
Scenario: Filtering cater to the user's selection
  Given I have entered city as "nablus", price as 2323, date as "2024-06-9"
  When the cater table is displayed
  Then all results should match the criteria of the cater that the user entered
@shahd
Scenario: Filtering cater to the user's null selection
  Given I have entered city as null, price as null, date as null
  When the cater table is displayed
  Then the result will be all the cater table content
@shahd
Scenario: Filtering venue to the user's selection
  Given I have entered city as "nablus", price as 2323, date as "2024-06-9", guests as 200
  When the venue table is displayed
  Then all results should match the criteria of the venue that the user entered
@shahd
Scenario: Filtering venue to user's null selection
  Given I have entered city as null, price as null, date as null, guests as null
  When the venue table is displayed
  Then the result will be all the venue table content
