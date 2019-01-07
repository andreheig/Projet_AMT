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
    private int scaleId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application application;

    private String name;

    private long max;

    @Version
    private Integer version;

    public Scale(){}
    public Scale(String name){
        this.name = name;
    }

    public int getScaleId() {
        return scaleId;
    }
    public void setBadgeId(int scaleId) {
        this.scaleId = scaleId;
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

    public Application getApplication() {
        return application;
    }
    public void setApplication(Application application) {
        this.application = application;
    }

}
