@ignore
Feature: Test User API functionality

  Scenario: Create and read a user
    Given there is internet connection
    When I create the user with name "Senna"
    Then I will have user created with success