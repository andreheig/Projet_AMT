package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.ApplicationRegistration;
import ch.heigvd.gamification.api.dto.ApplicationSummary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class ApplicationSteps {

  private final DefaultApi api = new DefaultApi();

  private ApplicationRegistration application;
  private List<ApplicationSummary> applications;

  private SharedData data;

  public ApplicationSteps(SharedData data){
    this.data = data;
  }

  @Given("^I have an application payload$")
  public void i_have_an_application_payload() throws Throwable {
    application = new ApplicationRegistration();
    application.setApplicationName(data.getFaker().app().name());
    application.setApplicationKeyUUID(UUID.randomUUID().toString());
    application.setApplicationSecretUUID(UUID.randomUUID().toString());
  }

  @When("^I POST it to the /applications endpoint$")
  public void i_POST_it_to_the_applications_endpoint() throws Throwable {
    try {
      ApiResponse response = api.postApplicationWithHttpInfo(application);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered apps with a GET on the /applications endpoint$")
  public void i_ask_for_a_list_of_registered_apps_with_a_GET_on_the_applications_endpoint() throws Throwable {
    applications = api.getAllApplications();
  }

  @Then("^I see my app in the list$")
  public void i_see_my_app_in_the_list() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    ApplicationSummary expected = new ApplicationSummary();
    expected.setApplicationName(application.getApplicationName());

    assertThat(applications).extracting("applicationName").contains(application.getApplicationName());
  }
}
