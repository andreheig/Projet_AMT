package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.BadgeThresholdRuleDto;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.RegistrationScale;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class BadgeThresholdSteps {

  private final DefaultApi api = new DefaultApi();

  private SharedData data;
  private BadgeThresholdRuleDto badgeThresholdRule;
  private List<BadgeThresholdRuleDto> badgesThresholdRulesDto;

  public BadgeThresholdSteps(SharedData data){
    this.data = data;
  }

  @Given("^I have a badgeThreshold payload$")
  public void i_have_a_badgeThreshold_payload() throws Throwable {
    badgeThresholdRule = new BadgeThresholdRuleDto();
    badgeThresholdRule.setName(data.getFaker().funnyName().name());
    badgeThresholdRule.setApplicationSecret(data.getSECRETUUID());
    badgeThresholdRule.setBadge(data.getBadgeName());
    badgeThresholdRule.setScale(data.getScaleName());
    badgeThresholdRule.setThreshold(data.getFaker().number().numberBetween(10, 1000));
  }

  @When("^I POST it to the /rules/badgeThreshold/\\{uuid\\} endpoint$")
  public void i_POST_it_to_the_rules_badgeThreshold_uuid_endpoint() throws Throwable {
    try {
      ApiResponse response = api.createBadgeThresholdRuleWithHttpInfo(data.getKEYUUID(), badgeThresholdRule);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered badgeThreshold with a GET on the /rules/badgeThreshold/\\{uuid\\} endpoint$")
  public void i_ask_for_a_list_of_registered_badgeThreshold_with_a_GET_on_the_rules_badgeThreshold_uuid_endpoint() throws Throwable {
    badgesThresholdRulesDto = api.findBadgeThresholdRules(data.getKEYUUID());
  }

  @Then("^I see my badgeThreshold in the list$")
  public void i_see_my_badgeThreshold_in_the_list() throws Throwable {
    BadgeThresholdRuleDto expected = new BadgeThresholdRuleDto();
    expected.setName(badgeThresholdRule.getName());
    //expected.setBadge(badgeThresholdRule.getBadge());
    assertThat(badgesThresholdRulesDto).extracting("name").contains(badgeThresholdRule.getName());
    //assertThat(badgesThresholdRulesDto).extracting("badge").contains(badgeThresholdRule.getName());
  }
}
