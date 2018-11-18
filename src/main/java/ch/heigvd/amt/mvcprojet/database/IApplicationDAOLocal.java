package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Application;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IApplicationDAOLocal extends IPaginatedDAO {
     List<Application> findUserApplication(int userId);

     Application loadAppli(int appId);

     void createAppli(int userId, Application appli);

     void updateAppli(Application appli);

     void deleteAppli(int appId);

     int countApplications();
}
