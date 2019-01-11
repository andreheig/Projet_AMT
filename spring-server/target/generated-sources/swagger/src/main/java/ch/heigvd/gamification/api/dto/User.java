package ch.heigvd.gamification.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2019-01-11T23:16:27.537+01:00")

public class User   {
  private String userId = null;

  private String name = null;

  private Integer numberOfEvents = null;

  private List<String> applications = new ArrayList<String>();

  public User userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User numberOfEvents(Integer numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
    return this;
  }

   /**
   * Get numberOfEvents
   * @return numberOfEvents
  **/
  @ApiModelProperty(value = "")
  public Integer getNumberOfEvents() {
    return numberOfEvents;
  }

  public void setNumberOfEvents(Integer numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
  }

  public User applications(List<String> applications) {
    this.applications = applications;
    return this;
  }

  public User addApplicationsItem(String applicationsItem) {
    this.applications.add(applicationsItem);
    return this;
  }

   /**
   * Get applications
   * @return applications
  **/
  @ApiModelProperty(value = "")
  public List<String> getApplications() {
    return applications;
  }

  public void setApplications(List<String> applications) {
    this.applications = applications;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.numberOfEvents, user.numberOfEvents) &&
        Objects.equals(this.applications, user.applications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, numberOfEvents, applications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    numberOfEvents: ").append(toIndentedString(numberOfEvents)).append("\n");
    sb.append("    applications: ").append(toIndentedString(applications)).append("\n");
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

