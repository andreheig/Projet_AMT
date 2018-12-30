package ch.heigvd.gamification.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * RegistrationBadges
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-12-18T12:20:18.370+01:00")

public class RegistrationBadges   {
  private String badgeName = null;

  private String username = null;

  private String password = null;

  public RegistrationBadges badgeName(String badgeName) {
    this.badgeName = badgeName;
    return this;
  }

   /**
   * Get badgeName
   * @return badgeName
  **/
  @ApiModelProperty(value = "")
  public String getBadgeName() {
    return badgeName;
  }

  public void setBadgeName(String badgeName) {
    this.badgeName = badgeName;
  }

  public RegistrationBadges username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(value = "")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public RegistrationBadges password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationBadges registrationBadges = (RegistrationBadges) o;
    return Objects.equals(this.badgeName, registrationBadges.badgeName) &&
        Objects.equals(this.username, registrationBadges.username) &&
        Objects.equals(this.password, registrationBadges.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(badgeName, username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationBadges {\n");
    
    sb.append("    badgeName: ").append(toIndentedString(badgeName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

