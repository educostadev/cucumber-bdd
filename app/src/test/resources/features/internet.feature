@success
Feature: A BDD scenario that will always success

  Scenario: This is a BDD that will always have success if your connected on internet
    Given there is internet connection
    When I access the internet
    Then I will have internet connection