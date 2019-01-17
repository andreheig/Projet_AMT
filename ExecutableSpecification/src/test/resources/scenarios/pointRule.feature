@PointRule
Feature: PointRule pointRule

  Scenario: Register a new pointRule without parameter
    Given I have a pointRule without parameter payload
    When I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 404 status code

  Scenario: Register a new pointRule without parameter
    Given I have a pointRule without parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Check that the pointRule  without parameter has been registered
    Given I have a pointRule without parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    And I ask for a list of registered pointRule with a GET on the /rules/points/{uuid} endpoint
    Then I see my pointRule in the list

  Scenario: Check that it is not possible to create two pointRule without parameter with the same name
    Given I have a pointRule without parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    And I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 422 status code

  Scenario: Register a new pointRule with parameter
    Given I have a pointRule with parameter payload
    When I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 404 status code

  Scenario: Register a new pointRule with parameter
    Given I have a pointRule with parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Check that the pointRule with parameter has been registered
    Given I have a pointRule with parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    And I ask for a list of registered pointRule with a GET on the /rules/points/{uuid} endpoint
    Then I see my pointRule in the list

  Scenario: Check that it is not possible to create two pointRule with parameter with the same name
    Given I have a pointRule without parameter payload
    And I have my scale payload
    And I POST it to the /scales/{uuid} endpoint
    When I POST it to the /rules/points/{uuid} endpoint
    And I POST it to the /rules/points/{uuid} endpoint
    Then I receive a 422 status code