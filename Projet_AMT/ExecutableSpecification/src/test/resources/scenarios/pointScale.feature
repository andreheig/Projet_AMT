@PointScale
Feature: Scale scale

  Scenario: Register a new scale
    Given I have a scale payload
    When I POST it to the /scales/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Check that the scale has been registered
    Given I have a scale payload
    When I POST it to the /scales/{uuid} endpoint
    And I ask for a list of registered scale's app with a GET on the /scales/{uuid} endpoint
    Then I see my scale in the list

  Scenario: Check that it is not possible to create two scale with the same name
    Given I have a scale payload
    When I POST it to the /scales/{uuid} endpoint
    And I POST it to the /scales/{uuid} endpoint
    Then I receive a 422 status code