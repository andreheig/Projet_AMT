@BadgeTimeRange
Feature: BadgeTimeRange badgeTimeRange

  Scenario: Register a new badgeTimeRange with badge
    Given I have a badgeTimeRange payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    When I POST it to the /rules/badgeTimeRange/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Register a new badgeTimeRange without badge
    Given I have a badgeTimeRange payload
    When I POST it to the /rules/badgeTimeRange/{uuid} endpoint
    Then I receive a 404 status code

  Scenario: Check that the badgeTimeRange with badge has been registered
    Given I have a badgeTimeRange payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    When I POST it to the /rules/badgeTimeRange/{uuid} endpoint
    And I ask for a list of registered badgeTimeRange with a GET on the /rules/badgeTimeRange/{uuid} endpoint
    Then I see my badgeTimeRange in the list

  Scenario: Check that it is not possible to create two badgeTimeRange with the same properties
    Given I have a badgeTimeRange payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    When I POST it to the /rules/badgeTimeRange/{uuid} endpoint
    And I POST it to the /rules/badgeTimeRange/{uuid} endpoint
    Then I receive a 422 status code