package ch.heigvd.gamification.model;

import javax.persistence.*;

/**
 * Changes the number of points awarded according to a rule when a given param with a given value is present
 * @see PointRule
 */
@Entity
public class PointRuleParam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private PointRule pointRule;

    private String paramName;
    private String paramValue;
    private Integer nbPoints;

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version;

    public PointRuleParam() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PointRule getPointRule() {
        return pointRule;
    }

    public void setPointRule(PointRule pointRule) {
        this.pointRule = pointRule;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(Integer nbPoints) {
        this.nbPoints = nbPoints;
    }
}
