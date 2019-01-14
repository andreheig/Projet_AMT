package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class Badge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    @Column(nullable = false)
    private String name;

    @Version
    private Integer version;

    public Badge(){}
    public Badge(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Application getApp() {
        return app;
    }
    public void setApp(Application app) {
        this.app = app;
    }

}
