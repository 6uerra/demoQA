@login
Feature: login

  Background: login
    Given I access demoQA
    When I log in with the user credentials
    Then I validate that the user information is displayed


  Scenario: Search for Non-Existent Book
    Given  I want to look for a book "QA"
    When  this does not exist
    Then  there should be no results a book "QA"


  Scenario: Search and Add Book to Cart by Name
    Given I search for a book by name "Git Pocket Guide"
    When I select the desired book from the search results
    And I add the book to my cart
    Then the book should be added successfully to my cart