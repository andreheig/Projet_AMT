package ch.heigvd.amt.mvcprojet.model;

public class Application {

    private int id;
    private String name;
    private String description;
    private String keyUUID;
    private String secretUUID;

    public Application(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Application(String name, String description, String keyUUID, String secretUUID){
        this.name = name;
        this.description = description;
        this.keyUUID = keyUUID;
        this.secretUUID = secretUUID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKeyUUID() { return keyUUID; }

    public String getSecretUUID() { return secretUUID; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyUUID(String keyUUID) {
        this.keyUUID = keyUUID;
    }

    public void setSecretUUID(String secretUUID) {
        this.secretUUID = secretUUID;
    }

}
