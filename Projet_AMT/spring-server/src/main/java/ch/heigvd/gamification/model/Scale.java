package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class Scale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    private String name;

    // TODO: à enlever?
    private long max;

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version;

    public Scale(){}
    public Scale(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setBadgeId(int scaleId) {
        this.id = scaleId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getMax() {
        return max;
    }
    public void setMax(long max) {
        this.max = max;
    }

    public Application getApp() {
        return app;
    }
    public void setApp(Application app) {
        this.app = app;
    }

}
