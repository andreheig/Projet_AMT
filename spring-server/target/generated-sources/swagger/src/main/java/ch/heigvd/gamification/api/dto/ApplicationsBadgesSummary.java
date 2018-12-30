package ch.heigvd.gamification.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * ApplicationsBadgesSummary
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-12-18T12:20:18.370+01:00")

public class ApplicationsBadgesSummary   {
  private String badgesName = null;

  public ApplicationsBadgesSummary badgesName(String badgesName) {
    this.badgesName = badgesName;
    return this;
  }

   /**
   * Get badgesName
   * @return badgesName
  **/
  @ApiModelProperty(value = "")
  public String getBadgesName() {
    return badgesName;
  }

  public void setBadgesName(String badgesName) {
    this.badgesName = badgesName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationsBadgesSummary applicationsBadgesSummary = (ApplicationsBadgesSummary) o;
    return Objects.equals(this.badgesName, applicationsBadgesSummary.badgesName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(badgesName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationsBadgesSummary {\n");
    
    sb.append("    badgesName: ").append(toIndentedString(badgesName)).append("\n");
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

