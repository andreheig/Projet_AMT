package ch.heigvd.amt.mvcprojet.model;

import java.util.ArrayList;
import java.util.List;

public class Developper extends User {

    private List<Integer> applications = new ArrayList<>();

    private boolean isAccountSuspended;
    private boolean hasToResetPasswordOnNextLogin;

    public Developper(int id, String firstName, String lastName, String mail, String password, String accountType,
                      List<Integer> applications, boolean isAccountSuspended, boolean hasToResetPasswordOnNextLogin){
        super(id, firstName, lastName, mail, password, accountType);
        this.applications = applications;
        this.isAccountSuspended = isAccountSuspended;
        this.hasToResetPasswordOnNextLogin = hasToResetPasswordOnNextLogin;
    }
    public void addApplication(Integer application){
        this.applications.add(application);
    }

    public List<Integer> getApplications() {
        return applications;
    }

    public boolean getIsAccountSuspended() {
        return isAccountSuspended;
    }

    public boolean getHasToResetPasswordOnNextLogin() {
        return hasToResetPasswordOnNextLogin;
    }

    public void setApplications(List<Integer> applications) {
        this.applications = applications;
    }

    public void setAccountSuspended(boolean accountSuspended) {
        isAccountSuspended = accountSuspended;
    }

    public void setHasToResetPasswordOnNextLogin(boolean hasToResetPasswordOnNextLogin) {
        this.hasToResetPasswordOnNextLogin = hasToResetPasswordOnNextLogin;
    }
}
