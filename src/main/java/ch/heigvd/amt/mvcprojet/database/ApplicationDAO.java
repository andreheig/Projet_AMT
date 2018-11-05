package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Application;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
public class ApplicationDAO {

    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    public List<Application> findUserApplication(int id) {
        List<Application> applications = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM Application INNER JOIN DevApp " +
                     "ON Application.appId = DevApp.appId INNER JOIN User ON " +
                     "User.userId = DevApp.userId WHERE User.userId = ? ORDER BY Application.appId ;")) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("appId");
                String nom = rs.getString("appName");
                String description = rs.getString("appDescription");
                applications.add(new Application(user_id, nom, description));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return applications;
    }

    // Permet de mettre à jour une application
    public void updateAppli(int id, Application appli) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "UPDATE Application SET appName = ?, appDescription = ? WHERE Application.appId = ?;")) {

            pstmt.setString(1, appli.getName());
            pstmt.setString(2, appli.getDescription());
            pstmt.setInt(3, id);

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //INSERT INTO Application (appId, appName, appDescription) VALUES (NULL, ?, ?);
    public void createAppli(Application appli) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO Application (appId, appName, appDescription) VALUES (NULL, ?, ?);")) {

            pstmt.setString(1, appli.getName());
            pstmt.setString(2, appli.getDescription());

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
