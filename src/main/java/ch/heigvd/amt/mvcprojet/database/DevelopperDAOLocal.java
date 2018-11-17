package ch.heigvd.amt.mvcprojet.database;


import ch.heigvd.amt.mvcprojet.model.Developper;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Local
public interface DevelopperDAOLocal {

    public List<Developper> findDevelopper(int page) ;

    public int getNumberOfDevelopper();

    public boolean isDeveloperSuspended(int id);

    public void suspendDeveloper(int id);

    public void reactivateDeveloper(int id);

    public void resetPassword(int devId, String newPassword);

    public void passwordWasResetted(int devId);

    public boolean hasToResetPassword(User user);

    public void addDevToApp(int devId, int appId);
}
