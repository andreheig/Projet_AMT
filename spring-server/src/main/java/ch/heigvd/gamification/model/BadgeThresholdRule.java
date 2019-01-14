package ch.heigvd.gamification.model;

import javax.persistence.*;

/**
 * Rule setting the threshold (number of points) in a scale before a badge is awarded
 */
@Entity
public class BadgeThresholdRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Application app;

    private String name;
    private Badge badge;
    private Scale scale;
    private Integer threshold;

    @Version
    private Integer version;

    public BadgeThresholdRule() {}

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

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
