/**
 * Gamification Platform API
 * **This is the documentation of the AMT Gamification Platform API** 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package ch.heigvd.gamification.api.dto;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * ApplicationsBadgesSummary
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-18T12:11:48.776+01:00")
public class ApplicationsBadgesSummary   {
  @SerializedName("badgesName")
  private String badgesName = null;

  public ApplicationsBadgesSummary badgesName(String badgesName) {
    this.badgesName = badgesName;
    return this;
  }

   /**
   * Get badgesName
   * @return badgesName
  **/
  @ApiModelProperty(example = "null", value = "")
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
