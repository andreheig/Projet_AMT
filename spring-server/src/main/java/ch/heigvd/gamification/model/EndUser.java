package ch.heigvd.gamification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class EndUser implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @OneToMany
  private List<Application> applications = new ArrayList<>();
  
  private String idInGamifiedApplication;
  
  private int numberOfEvents;

  private String name;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public List<Application> getApplications() {
    return applications;
  }
  public void setApplications(List<Application> applications) {
    this.applications = applications;
  }
  public void addApplication (Application application){ this.applications.add(application); }
  public Application getApplicationName(String name){
    for (Application app : applications) {
      if (app.getName().equalsIgnoreCase(name)){
        return app;
      }
    }
    return null;
  }

  public String getIdInGamifiedApplication() {
    return idInGamifiedApplication;
  }
  public void setIdInGamifiedApplication(String idInGamifiedApplication) {
    this.idInGamifiedApplication = idInGamifiedApplication;
  }

  public int getNumberOfEvents() {
    return numberOfEvents;
  }
  public void setNumberOfEvents(int numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
  }
  
}
