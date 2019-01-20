package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
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
public class BadgeSteps {

  private final DefaultApi api = new DefaultApi();

  private SharedData data;
  private RegistrationBadge badge;
  private List<ApplicationsBadgesSummary> badges;


  public BadgeSteps(SharedData data){
    this.data = data;
  }

  @Given("^I have a badge payload$")
  public void i_have_a_badge_payload() throws Throwable {
    badge = new RegistrationBadge();
    badge.setBadgeName(data.getFaker().funnyName().name());
    badge.setApplicationSecret(data.getSECRETUUID());
  }

  @Given("^I have my badge payload$")
  public void i_have_my_badge_payload() throws Throwable {
    badge = new RegistrationBadge();
    badge.setBadgeName(data.getBadgeName());
    badge.setApplicationSecret(data.getSECRETUUID());
  }

  @When("^I POST it to the /badges/\\{uuid\\} endpoint$")
  public void i_POST_it_to_the_badges_uuid_endpoint() throws Throwable {
    try {
      ApiResponse response = api.postBadgeWithHttpInfo(data.getKEYUUID(), badge);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered badge's apps with a GET on the /badges/\\{uuid\\} endpoint$")
  public void i_ask_for_a_list_of_registered_badge_s_apps_with_a_GET_on_the_badges_uuid_endpoint() throws Throwable {
    badges = api.findApplicationBadges(data.getKEYUUID());
  }

  @Then("^I see my badge in the list$")
  public void i_see_my_badge_in_the_list() throws Throwable {
    ApplicationsBadgesSummary expected = new ApplicationsBadgesSummary();
    expected.setBadgesName(badge.getBadgeName());
    assertThat(badges).extracting("badgesName").contains(badge.getBadgeName());
  }
}
