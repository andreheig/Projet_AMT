package ch.heigvd.amt.mvcprojet.model;

import java.util.ArrayList;
import java.util.List;

public class Developper {

    private int user_id;
    private List<Application> applications = new ArrayList<>();

    public Developper(int user_id, List<Application> applications){
        this.user_id = user_id;
        this.applications = applications;
    }
    public void addApplication(Application application){
        this.applications.add(application);
    }

    public int getUser_id() {
        return user_id;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
