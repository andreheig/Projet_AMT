package ch.heigvd.gamification.model;

import javax.persistence.*;

/**
 * Rule setting the max amount of time between the occurrence of two events (of given types) for a badge to be awarded
 */
@Entity
public class BadgeTimeRangeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Application app;

    private String name;
    private String firstEventType;
    private String secondEventType;
    private Integer rangeInSeconds;

    @OneToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version;

    public BadgeTimeRangeRule() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstEventType() {
        return firstEventType;
    }

    public void setFirstEventType(String firstEventType) {
        this.firstEventType = firstEventType;
    }

    public String getSecondEventType() {
        return secondEventType;
    }

    public void setSecondEventType(String secondEventType) {
        this.secondEventType = secondEventType;
    }

    public Integer getRangeInSeconds() {
        return rangeInSeconds;
    }

    public void setRangeInSeconds(Integer rangeInSeconds) {
        this.rangeInSeconds = rangeInSeconds;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
