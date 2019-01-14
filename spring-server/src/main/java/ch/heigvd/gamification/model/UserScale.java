package ch.heigvd.gamification.model;

import javax.persistence.*;

/** Stores the number of points of an user in a given scale */
@Entity
public class UserScale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EndUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scale_id")
    private Scale scale;

    private Integer nbPoints;

    @Version
    private Integer version;

    public UserScale() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EndUser getUser() {
        return user;
    }

    public void setUser(EndUser user) {
        this.user = user;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Integer getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(Integer nbPoints) {
        this.nbPoints = nbPoints;
    }
}
