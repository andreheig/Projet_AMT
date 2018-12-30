$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("registration.feature");
formatter.feature({
  "line": 1,
  "name": "Application registration",
  "description": "",
  "id": "application-registration",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Register a new application",
  "description": "",
  "id": "application-registration;register-a-new-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have an application payload",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I POST it to the /registrations endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I receive a 201 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.i_have_an_application_payload()"
});
formatter.result({
  "duration": 330391520,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_POST_it_to_the_registrations_endpoint()"
});
formatter.result({
  "duration": 1712050532,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 12
    }
  ],
  "location": "ApplicationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 3165723,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Check that the application has been registered",
  "description": "",
  "id": "application-registration;check-that-the-application-has-been-registered",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I have an application payload",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I POST it to the /registrations endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I ask for a list of registered apps with a GET on the /registrations endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I see my app in the list",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.i_have_an_application_payload()"
});
formatter.result({
  "duration": 43031,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_POST_it_to_the_registrations_endpoint()"
});
formatter.result({
  "duration": 16867200,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_ask_for_a_list_of_registered_apps_with_a_GET_on_the_registrations_endpoint()"
});
formatter.result({
  "duration": 139081011,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_see_my_app_in_the_list()"
});
formatter.result({
  "duration": 51013315,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Check that it is not possible to create two apps with the same name",
  "description": "",
  "id": "application-registration;check-that-it-is-not-possible-to-create-two-apps-with-the-same-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I have an application payload",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "I POST it to the /registrations endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I POST it to the /registrations endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I receive a 422 status code",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.i_have_an_application_payload()"
});
formatter.result({
  "duration": 27350,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_POST_it_to_the_registrations_endpoint()"
});
formatter.result({
  "duration": 17657445,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.i_POST_it_to_the_registrations_endpoint()"
});
formatter.result({
  "duration": 32190741,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "422",
      "offset": 12
    }
  ],
  "location": "ApplicationSteps.i_receive_a_status_code(int)"
});
formatter.result({
  "duration": 90804,
  "status": "passed"
});
formatter.uri("simple_event_processing.feature");
formatter.feature({
  "line": 1,
  "name": "Simple event processing",
  "description": "",
  "id": "simple-event-processing",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "a token for a new gamified application A1",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 39
    }
  ],
  "location": "EventProcessingSteps.a_token_for_a_new_gamified_application(String)"
});
formatter.result({
  "duration": 84780902,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "send the first event for a user of the gamified application",
  "description": "",
  "id": "simple-event-processing;send-the-first-event-for-a-user-of-the-gamified-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "a user U1 of the gamified application A1",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the application A1 POSTs 1 payload for events associated to user U1 on the /events endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the application A1 GETs user U1 from the /users/ endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "it receives a 200 status code",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "the payload in the response has a property numberOfEvents with a value of 1",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "U1",
      "offset": 7
    },
    {
      "val": "A1",
      "offset": 38
    }
  ],
  "location": "EventProcessingSteps.a_user_U_of_the_gamified_application_A(String,String)"
});
formatter.result({
  "duration": 6873713,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 16
    },
    {
      "val": "1",
      "offset": 25
    },
    {
      "val": "U1",
      "offset": 65
    }
  ],
  "location": "EventProcessingSteps.the_application_A_POSTs_payload_s_for_events_associated_to_user_U_on_the_events_endpoint(String,int,String)"
});
formatter.result({
  "duration": 147754018,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 16
    },
    {
      "val": "U1",
      "offset": 29
    }
  ],
  "location": "EventProcessingSteps.the_application_A_GETs_user_U_from_the_users_endpoint(String,String)"
});
formatter.result({
  "duration": 29773326,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 14
    }
  ],
  "location": "EventProcessingSteps.it_receives_a_status_code(int)"
});
formatter.result({
  "duration": 105390,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 74
    }
  ],
  "location": "EventProcessingSteps.the_payload_in_the_response_has_a_property_numberOfEvents_with_a_value_of(int)"
});
formatter.result({
  "duration": 102837,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "a token for a new gamified application A1",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 39
    }
  ],
  "location": "EventProcessingSteps.a_token_for_a_new_gamified_application(String)"
});
formatter.result({
  "duration": 41194506,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "send the first 2 events for a user of the gamified application",
  "description": "",
  "id": "simple-event-processing;send-the-first-2-events-for-a-user-of-the-gamified-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "a user U1 of the gamified application A1",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "the application A1 POSTs 2 payloads for events associated to user U1 on the /events endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the application A1 GETs user U1 from the /users/ endpoint",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "it receives a 200 status code",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "the payload in the response has a property numberOfEvents with a value of 2",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "U1",
      "offset": 7
    },
    {
      "val": "A1",
      "offset": 38
    }
  ],
  "location": "EventProcessingSteps.a_user_U_of_the_gamified_application_A(String,String)"
});
formatter.result({
  "duration": 91533,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 16
    },
    {
      "val": "2",
      "offset": 25
    },
    {
      "val": "U1",
      "offset": 66
    }
  ],
  "location": "EventProcessingSteps.the_application_A_POSTs_payload_s_for_events_associated_to_user_U_on_the_events_endpoint(String,int,String)"
});
formatter.result({
  "duration": 56359416,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A1",
      "offset": 16
    },
    {
      "val": "U1",
      "offset": 29
    }
  ],
  "location": "EventProcessingSteps.the_application_A_GETs_user_U_from_the_users_endpoint(String,String)"
});
formatter.result({
  "duration": 11998822,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 14
    }
  ],
  "location": "EventProcessingSteps.it_receives_a_status_code(int)"
});
formatter.result({
  "duration": 91898,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 74
    }
  ],
  "location": "EventProcessingSteps.the_payload_in_the_response_has_a_property_numberOfEvents_with_a_value_of(int)"
});
formatter.result({
  "duration": 97002,
  "status": "passed"
});
});