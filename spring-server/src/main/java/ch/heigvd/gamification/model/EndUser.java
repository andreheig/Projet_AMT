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

  @ManyToOne
  private Application application;
  
  private String idInGamifiedApplication;
  
  private int numberOfEvents;

  private String name;

  @Version
  private Integer version;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public Application getApplication(){ return this.application; }
  public void setApplication(Application application){ this.application = application; }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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
