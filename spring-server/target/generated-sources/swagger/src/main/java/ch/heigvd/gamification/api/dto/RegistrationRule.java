package ch.heigvd.gamification.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * RegistrationRule
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2019-01-11T23:16:27.537+01:00")

public class RegistrationRule   {
  private String ruleName = null;

  private String ruleType = null;

  private String applicationSecret = null;

  private Integer numberOfPoint = null;

  public RegistrationRule ruleName(String ruleName) {
    this.ruleName = ruleName;
    return this;
  }

   /**
   * Get ruleName
   * @return ruleName
  **/
  @ApiModelProperty(value = "")
  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public RegistrationRule ruleType(String ruleType) {
    this.ruleType = ruleType;
    return this;
  }

   /**
   * Get ruleType
   * @return ruleType
  **/
  @ApiModelProperty(value = "")
  public String getRuleType() {
    return ruleType;
  }

  public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
  }

  public RegistrationRule applicationSecret(String applicationSecret) {
    this.applicationSecret = applicationSecret;
    return this;
  }

   /**
   * Get applicationSecret
   * @return applicationSecret
  **/
  @ApiModelProperty(value = "")
  public String getApplicationSecret() {
    return applicationSecret;
  }

  public void setApplicationSecret(String applicationSecret) {
    this.applicationSecret = applicationSecret;
  }

  public RegistrationRule numberOfPoint(Integer numberOfPoint) {
    this.numberOfPoint = numberOfPoint;
    return this;
  }

   /**
   * Get numberOfPoint
   * @return numberOfPoint
  **/
  @ApiModelProperty(value = "")
  public Integer getNumberOfPoint() {
    return numberOfPoint;
  }

  public void setNumberOfPoint(Integer numberOfPoint) {
    this.numberOfPoint = numberOfPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationRule registrationRule = (RegistrationRule) o;
    return Objects.equals(this.ruleName, registrationRule.ruleName) &&
        Objects.equals(this.ruleType, registrationRule.ruleType) &&
        Objects.equals(this.applicationSecret, registrationRule.applicationSecret) &&
        Objects.equals(this.numberOfPoint, registrationRule.numberOfPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ruleName, ruleType, applicationSecret, numberOfPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationRule {\n");
    
    sb.append("    ruleName: ").append(toIndentedString(ruleName)).append("\n");
    sb.append("    ruleType: ").append(toIndentedString(ruleType)).append("\n");
    sb.append("    applicationSecret: ").append(toIndentedString(applicationSecret)).append("\n");
    sb.append("    numberOfPoint: ").append(toIndentedString(numberOfPoint)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

