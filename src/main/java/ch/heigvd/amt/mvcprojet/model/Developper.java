package ch.heigvd.amt.mvcprojet.model;

import java.util.ArrayList;
import java.util.List;

public class Developper {

    private int id;
    private List<Application> applications = new ArrayList<>();

    public Developper(int user_id, List<Application> applications){
        this.id = user_id;
        this.applications = applications;
    }
    public void addApplication(Application application){
        this.applications.add(application);
    }

    public int getId() {
        return id;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
