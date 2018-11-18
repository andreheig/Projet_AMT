package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.Local;

@Local
public interface IDevelopperDAOLocal extends IPaginatedDAO {

     boolean isDeveloperSuspended(int id);

     void suspendDeveloper(int id);

     void reactivateDeveloper(int id);

     void resetPassword(int devId, String newPassword);

     void passwordWasResetted(int devId);

     boolean hasToResetPassword(User user);

     void addDevToApp(int devId, int appId);
}
