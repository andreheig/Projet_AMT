package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Application;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import javax.transaction.Synchronization;
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
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return applications;
    }

    public Application loadAppli(int appId) {
        Application appli = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM Application WHERE Application.appId = ?")) {

            pstmt.setInt(1, appId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            appli = new Application(appId, rs.getString("appName"),
                    rs.getString("appDescription"));

        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appli;
    }

    public void createAppli(int userId, Application appli) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO Application (appName, appDescription, appKey, appSecret) VALUES (?, ?, ?, ?);")) {

            pstmt.setString(1, appli.getName());
            pstmt.setString(2, appli.getDescription());
            pstmt.setString(3, appli.getKeyUUID());
            pstmt.setString(4, appli.getSecretUUID());
            pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        int appli_id = getLastInseredID();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO DevApp (userId, appId) VALUES (?, ?);")) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, appli_id);
            pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Permet de mettre à jour une application
    public void updateAppli(Application appli) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "UPDATE Application SET appName = ?, appDescription = ? WHERE Application.appId = ?;")) {
            pstmt.setString(1, appli.getName());
            pstmt.setString(2, appli.getDescription());
            pstmt.setInt(3, appli.getId());
            pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAppli(int appId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement deleteDevAppStmt = connection.prepareStatement(
                     "DELETE FROM DevApp WHERE appId = ?;");
             PreparedStatement deleteAppStmt = connection.prepareStatement(
                     "DELETE FROM Application WHERE appId = ?;")) {
            deleteDevAppStmt.setInt(1, appId);
            deleteDevAppStmt.executeQuery();
            deleteAppStmt.setInt(1, appId);
            deleteAppStmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int getLastInseredID() {
        int app_id = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT LAST_INSERT_ID();")) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                app_id = rs.getInt("LAST_INSERT_ID()");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return app_id;
    }
}
