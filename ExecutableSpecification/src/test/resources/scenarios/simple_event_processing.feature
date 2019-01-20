@Event
Feature: Simple event processing

  Scenario: send the first event for a user of the gamified application
    Given I have an Event payload
    When I post it to the /events endpoint
    And I ask the user U1 from the /users/{id} endpoint
    Then I receive a 200 status code
    And the payload in the response has a property numberOfEvents with a value of 1

  Scenario: send the first 2 events for a user of the gamified application
    Given I have two Event payload
    When I post the first to the /events endpoint
    And I post the second to the /events endpoint
    And I ask the user U1 from the /users/{id} endpoint
    Then I receive a 200 status code
    And the payload in the response has a property numberOfEvents with a value of 3

  Scenario: send event for a user of the gamified application and check winning badge
    Given I have an Event payload
    When I post it to the /events endpoint
    And I ask the user U1 from the /users/{id} endpoint
    Then I receive a 200 status code
    And I see the badge in the list

  Scenario: send event for a user of the gamified application and check winning badge
    Given I have an Event payload
    When I post it to the /events endpoint
    And I ask the user U1 from the /users/{id} endpoint
    Then I receive a 200 status code
    And I see the userScale in the list grow-up
