@login
Feature: login

  Scenario:  Verify successful login
    Given I access demoQA
    When I log in with the user credentials
    Then I validate that the user information is displayed
