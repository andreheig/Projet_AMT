package ch.heigvd.gamification.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Olivier Liechti
 */
@Entity
@Table(name = "Application")
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long appId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String keyUUID;

    @Column(nullable = false)
    private String secretUUID;

    public Application(){}

    public Application(int id, String name, String keyUUID, String secretUUID){
        this.appId = id;
        this.name = name;
        this.keyUUID = keyUUID;
        this.secretUUID = secretUUID;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyUUID() {
        return keyUUID;
    }

    public void setKeyUUID(String keyUUID) {
        this.keyUUID = keyUUID;
    }

    public String getSecretUUID() {
        return secretUUID;
    }

    public void setSecretUUID(String keyUUID) {
        this.secretUUID = keyUUID;
    }

}
