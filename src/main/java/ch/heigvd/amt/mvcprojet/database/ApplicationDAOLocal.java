package ch.heigvd.amt.mvcprojet.database;


import ch.heigvd.amt.mvcprojet.model.Application;

import javax.ejb.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Local
public interface ApplicationDAOLocal {
    public List<Application> findUserApplication(int userId);

    public Application loadAppli(int appId);

    public void createAppli(int userId, Application appli);

    // Permet de mettre à jour une application
    public void updateAppli(Application appli);

    public void deleteAppli(int appId);
}
