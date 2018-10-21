package ch.heigvd.amt.mvcprojet.model;

public class Application {

    private int application_id;
    private String name;
    private String description;

    public Application(int application_id, String name, String description){
        this.application_id = application_id;
        this.name = name;
        this.description = description;
    }

    public int getApplication_id() {
        return application_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
