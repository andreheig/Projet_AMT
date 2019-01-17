@BadgeThreshold
Feature: BadgeThreshold badgeThreshold

  Scenario: Register a new badgeThreshold
    Given I have a badgeThreshold payload
    When I POST it to the /rules/badgeThreshold/{uuid} endpoint
    Then I receive a 404 status code

  Scenario: Register a new badgeThreshold
    Given I have a badgeThreshold payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/badgeThreshold/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Check that the badgeThreshold has been registered
    Given I have a badgeThreshold payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/badgeThreshold/{uuid} endpoint
    And I ask for a list of registered badgeThreshold with a GET on the /rules/badgeThreshold/{uuid} endpoint
    Then I see my badgeThreshold in the list

  Scenario: Check that it is not possible to create two badgeThreshold with the same properties
    Given I have a badgeThreshold payload
    And I have my badge payload
    And I POST it to the /badges/{uuid} endpoint
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/badgeThreshold/{uuid} endpoint
    And I POST it to the /rules/badgeThreshold/{uuid} endpoint
    Then I receive a 422 status code