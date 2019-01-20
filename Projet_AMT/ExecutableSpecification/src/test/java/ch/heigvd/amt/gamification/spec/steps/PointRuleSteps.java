package ch.heigvd.amt.gamification.spec.steps;

import ch.heigvd.gamification.ApiException;
import ch.heigvd.gamification.ApiResponse;
import ch.heigvd.gamification.api.DefaultApi;
import ch.heigvd.gamification.api.dto.ApplicationsScalesSummary;
import ch.heigvd.gamification.api.dto.PointRuleDto;
import ch.heigvd.gamification.api.dto.PointRuleParamDto;
import ch.heigvd.gamification.api.dto.RegistrationScale;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
public class PointRuleSteps {

  private final DefaultApi api = new DefaultApi();

  private SharedData data;
  private PointRuleDto pointRuleDto;
  private List<PointRuleDto> pointsRuleDto;

  public PointRuleSteps(SharedData data){ this.data = data; }

  @Given("^I have a pointRule without parameter payload$")
  public void i_have_a_pointRule_without_parameter_payload() throws Throwable {
    pointRuleDto = new PointRuleDto();
    pointRuleDto.setApplicationSecret(data.getSECRETUUID());
    pointRuleDto.setDefaultNbPoints(data.getFaker().number().numberBetween(10, 100));
    pointRuleDto.setName(data.getFaker().harryPotter().character());
    pointRuleDto.setEventType(data.getPointRuleEventType());
    pointRuleDto.setScale(data.getScaleName());
  }

  @Given("^I have a pointRule with parameter payload$")
  public void i_have_a_pointRule_with_parameter_payload() throws Throwable {
    List<PointRuleParamDto> params = new ArrayList<>();
    PointRuleParamDto param = new PointRuleParamDto();
    param.setParamName(data.getFaker().book().title());
    param.setNbPoints(data.getFaker().number().numberBetween(10, 100));
    param.setParamValue(data.getFaker().weather().description());
    params.add(param);
    pointRuleDto = new PointRuleDto();
    pointRuleDto.setApplicationSecret(data.getSECRETUUID());
    pointRuleDto.setDefaultNbPoints(data.getFaker().number().numberBetween(10, 100));
    pointRuleDto.setName(data.getFaker().harryPotter().character());
    pointRuleDto.setEventType(data.getPointRuleEventType());
    pointRuleDto.setPointRuleParams(params);
    pointRuleDto.setScale(data.getScaleName());
    }

  @When("^I POST it to the /rules/points/\\{uuid\\} endpoint$")
  public void i_POST_it_to_the_rules_points_uuid_endpoint() throws Throwable {
    try {
      ApiResponse response = api.createPointRuleWithHttpInfo(data.getKEYUUID(), pointRuleDto);
      data.setStatusCode(response.getStatusCode());
    } catch (ApiException e) {
      data.setStatusCode(e.getCode());
    }
  }

  @When("^I ask for a list of registered pointRule with a GET on the /rules/points/\\{uuid\\} endpoint$")
  public void i_ask_for_a_list_of_registered_pointRule_with_a_GET_on_the_rules_points_uuid_endpoint() throws Throwable {
    pointsRuleDto = api.findPointRules(data.getKEYUUID());
  }

  @Then("^I see my pointRule in the list$")
  public void i_see_my_pointRule_in_the_list() throws Throwable {
    PointRuleDto expected = new PointRuleDto();
    expected.setName(pointRuleDto.getName());

    assertThat(pointsRuleDto).extracting("name").contains(pointRuleDto.getName());

  }
}
