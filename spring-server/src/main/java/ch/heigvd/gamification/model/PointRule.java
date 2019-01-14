package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.util.List;

/**
 * Rule setting the effect of an event on the number of points in a particular scale
 * @see ch.heigvd.gamification.model.PointRuleParam
 */
@Entity
public class PointRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    private String name;
    private String eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scale scale;

    private Integer defaultNbPoints;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "pointRule")
    private List<PointRuleParam> pointRuleParams;

    @Version
    private Integer version;

    public PointRule() {}

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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Integer getDefaultNbPoints() {
        return defaultNbPoints;
    }

    public void setDefaultNbPoints(Integer defaultNbPoints) {
        this.defaultNbPoints = defaultNbPoints;
    }

    public List<PointRuleParam> getPointRuleParams() {
        return pointRuleParams;
    }

    public void setPointRuleParams(List<PointRuleParam> pointRuleParams) {
        this.pointRuleParams = pointRuleParams;
    }
}
