$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("badge.feature");
formatter.feature({
  "line": 2,
  "name": "Badge badge",
  "description": "",
  "id": "badge-badge",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Badge"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Register a new badge",
  "description": "",
  "id": "badge-badge;register-a-new-badge",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I have a badge payload",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I POST it to the /badges/{uuid}?\u003duuid endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "BadgeSteps.i_have_a_badge_payload()"
});
formatter.result({
  "duration": 988920526,
  "status": "passed"
});
formatter.match({
  "location": "BadgeSteps.i_POST_it_to_the_badges_uuid_endpoint()"
});
