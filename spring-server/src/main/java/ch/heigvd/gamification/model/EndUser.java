package ch.heigvd.gamification.model;

import java.io.Serializable;
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

  @ManyToOne(fetch = FetchType.LAZY)
  private Application app;
  
  private String idInGamifiedApplication;
  
  private int numberOfEvents;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user")
  private List<UserBadge> badges;

  @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "user")
  private List<UserScale> pointsInScales;

  @Version
  @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
  private long version;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }

  public Application getApp(){ return this.app; }
  public void setApp(Application app){ this.app = app; }

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

  public List<UserBadge> getBadges() {
    return badges;
  }

  public void setBadges(List<UserBadge> badges) {
    this.badges = badges;
  }

  public List<UserScale> getPointsInScales() {
    return pointsInScales;
  }

  public void setPointsInScales(List<UserScale> pointsInScales) {
    this.pointsInScales = pointsInScales;
  }
}
