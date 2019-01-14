package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class Rule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    private String name;

    private String type;

    private Scale scale;

    private int numberOfPoint;

    @Version
    private Integer version;


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

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Application getApp() {
        return app;
    }
    public void setApp(Application app) {
        this.app = app;
    }

    public Scale getScale() { return scale; }
    public void setScale(Scale scale) { this.scale = scale; }

    public int getNumberOfPoint() {
        return this.numberOfPoint;
    }
    public void setNumberOfPoint(int numberOfPoint) {
        this.numberOfPoint = numberOfPoint;
    }
}
