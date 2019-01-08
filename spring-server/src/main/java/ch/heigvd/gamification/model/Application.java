package ch.heigvd.gamification.model;

import org.aspectj.lang.annotation.DeclareAnnotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;

/**
 *
 * @author Olivier Liechti
 */
@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long appId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String keyUUID;

    @Column(nullable = false, unique = true)
    private String secretUUID;


    @OneToMany
    private List<Badge> badges = new ArrayList<>();

    @OneToMany
    private List<Scale> scales = new ArrayList<>();

    @OneToMany
    private List<PointRule> rules = new ArrayList<>();

    @ManyToMany
    private List<EndUser> users = new ArrayList<>();

    @Version
    private Integer version;

    public Application(){}

    public Application(int id, String name, String keyUUID, String secretUUID){
        this.appId = id;
        this.name = name;
        this.keyUUID = keyUUID;
        this.secretUUID = secretUUID;
    }

    public Application getApplication(){
        return this;
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

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public void addBadge(Badge badge){
        this.badges.add(badge);
    }

    public void updateBadge(Badge badge){

    }

    public List<Scale> getScales() {
        return scales;
    }

    public void setScales(List<Scale> scales) {
        this.scales = scales;
    }

    public void addScale(Scale scale){ this.scales.add(scale); }

    public void updateScale(Scale scale){

    }

    public List<PointRule> getPointRules() {
        return rules;
    }

    public void setPointRules(List<PointRule> rules) {
        this.rules = rules;
    }

    public void addPointRule(PointRule rule){ this.rules.add(rule); }

    public void updatePointRule(PointRule rule){

    }

    public List<EndUser> getUsers() {
        return users;
    }

    public void setUsers(List<EndUser> users) {
        this.users = users;
    }

    public void addUser(EndUser users){ this.users.add(users); }

    public void updateUser(EndUser users){

    }
}
