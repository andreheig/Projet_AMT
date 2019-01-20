package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.BadgeTimeRangeRuleDto;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class BadgeTimeRangeSteps {

  private final DefaultApi api = new DefaultApi();

  private SharedData data;
  private BadgeTimeRangeRuleDto badgeTimeRangeRuleDto;
  private List<BadgeTimeRangeRuleDto> badgeTimeRangeRulesDto;

  public BadgeTimeRangeSteps(SharedData data){
    this.data = data;
  }

  @Given("^I have a badgeTimeRange payload$")
  public void i_have_a_badgeTimeRange_payload() throws Throwable {
    badgeTimeRangeRuleDto = new BadgeTimeRangeRuleDto();
    badgeTimeRangeRuleDto.setApplicationSecret(data.getSECRETUUID());
    badgeTimeRangeRuleDto.setName(data.getFaker().hobbit().character());
    badgeTimeRangeRuleDto.setFirstEventType(data.getFaker().job().title());
    badgeTimeRangeRuleDto.setSecondEventType(data.getFaker().job().title());
    badgeTimeRangeRuleDto.setRangeInSeconds(data.getFaker().number().numberBetween(3600,1000000));
    badgeTimeRangeRuleDto.setBadge(data.getBadgeName());
  }

  @When("^I POST it to the /rules/badgeTimeRange/\\{uuid\\} endpoint$")
  public void i_POST_it_to_the_rules_badgeTimeRange_uuid_endpoint() throws Throwable {
    try {
      ApiResponse response = api.createBadgeTimeRangeRuleWithHttpInfo(data.getKEYUUID(), badgeTimeRangeRuleDto);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered badgeTimeRange with a GET on the /rules/badgeTimeRange/\\{uuid\\} endpoint$")
  public void i_ask_for_a_list_of_registered_badgeTimeRange_with_a_GET_on_the_rules_badgeTimeRange_uuid_endpoint() throws Throwable {
    badgeTimeRangeRulesDto = api.findBadgeTimeRangeRules(data.getKEYUUID());
  }

  @Then("^I see my badgeTimeRange in the list$")
  public void i_see_my_badgeTimeRange_in_the_list() throws Throwable {
    BadgeTimeRangeRuleDto expected = new BadgeTimeRangeRuleDto();
    expected.setBadge(badgeTimeRangeRuleDto.getName());
    assertThat(badgeTimeRangeRulesDto).extracting("name").contains(badgeTimeRangeRuleDto.getName());
  }
}
