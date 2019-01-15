package ch.heigvd.gamification.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String keyUUID;

    @Column(nullable = false, unique = true)
    private String secretUUID;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "app")
    private List<Badge> badges = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "app")
    private List<Scale> scales = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "app")
    private List<PointRule> pointRules = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "app")
    private List<EndUser> users = new ArrayList<>();

    @Version
    @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version;

    public Application(){}

    public Application(int id, String name, String keyUUID, String secretUUID){
        this.id = id;
        this.name = name;
        this.keyUUID = keyUUID;
        this.secretUUID = secretUUID;
    }

    public Application getApplication(){
        return this;
    }


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
        return pointRules;
    }

    public void setPointRules(List<PointRule> rules) {
        this.pointRules = rules;
    }

    public void addPointRule(PointRule rule){ this.pointRules.add(rule); }

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
