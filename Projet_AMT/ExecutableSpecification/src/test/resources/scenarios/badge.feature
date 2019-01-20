@Badge
Feature: Badge badge

  Scenario: Register a new badge
    Given I have a badge payload
    When I POST it to the /badges/{uuid} endpoint
    Then I receive a 201 status code

  Scenario: Check that the badge has been registered
    Given I have a badge payload
    When I POST it to the /badges/{uuid} endpoint
    And I ask for a list of registered badge's apps with a GET on the /badges/{uuid} endpoint
    Then I see my badge in the list

  Scenario: Check that it is not possible to create two badges with the same name
    Given I have a badge payload
    When I POST it to the /badges/{uuid} endpoint
    And I POST it to the /badges/{uuid} endpoint
    Then I receive a 422 status code