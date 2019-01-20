package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EventHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    @ManyToOne(fetch = FetchType.LAZY)
    private EndUser user;

    private String eventType;

    private Date lastOccurenceDate;

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version;

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

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getLastOccurenceDate() {
        return lastOccurenceDate;
    }

    public void setLastOccurenceDate(Date lastOccurenceDate) {
        this.lastOccurenceDate = lastOccurenceDate;
    }
}
