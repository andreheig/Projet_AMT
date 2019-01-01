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
    private Application application;

    @Column(unique = true)
    private String name;

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

    public Application getApplication() {
        return application;
    }
    public void setApplication(Application application) {
        this.application = application;
    }

}
