package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.ApplicationRegistration;
import ch.heigvd.gamification.api.dto.ApplicationSummary;
import ch.heigvd.gamification.api.dto.ApplicationsScalesSummary;
import ch.heigvd.gamification.api.dto.RegistrationScale;
import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class PointScaleSteps {

  private final DefaultApi api = new DefaultApi();

  private SharedData data;
  private RegistrationScale scale;
  private List<ApplicationsScalesSummary> scales;

  public PointScaleSteps(SharedData data){ this.data = data; }

  @Given("^I have a scale payload$")
  public void i_have_a_scale_payload() throws Throwable {
    scale = new RegistrationScale();
    Faker faker = new Faker();
    scale.setApplicationSecret(data.getSECRETUUID());
    scale.setScaleMax(faker.number().numberBetween(100, 10000000));
    scale.setScaleName(faker.chuckNorris().fact());
    data.setScaleName(scale.getScaleName());
  }

  @Given("^I have my scale payload$")
  public void i_have_my_scale_payload() throws Throwable {
    scale = new RegistrationScale();
    scale.setApplicationSecret(data.getSECRETUUID());
    scale.setScaleMax(data.getFaker().number().numberBetween(100, 10000000));
    scale.setScaleName(data.getScaleName());
    data.setScaleName(scale.getScaleName());
  }

  @When("^I POST it to the /scales/\\{uuid\\} endpoint$")
  public void i_POST_it_to_the_scales_uuid_endpoint() throws Throwable {
    try {
      ApiResponse response = api.postScaleWithHttpInfo(data.getKEYUUID(), scale);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered scale's app with a GET on the /scales/\\{uuid\\} endpoint$")
  public void i_ask_for_a_list_of_registered_scale_s_app_with_a_GET_on_the_scales_uuid_endpoint() throws Throwable {
    scales = api.findApplicationScales(data.getKEYUUID());
  }

  @Then("^I see my scale in the list$")
  public void i_see_my_scale_in_the_list() throws Throwable {
    ApplicationsScalesSummary expected = new ApplicationsScalesSummary();
    expected.setScaleName(scale.getScaleName());
    expected.setScaleMax(scale.getScaleMax());

    assertThat(scale).extracting("scaleName").contains(scale.getScaleName());
    assertThat(scale).extracting("scaleMax").contains(scale.getScaleMax());

  }
}
