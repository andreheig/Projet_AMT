package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Application;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
@LocalBean
public class ApplicationDAO implements IPaginatedDAO {

    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    @Override
    public int getTotalNumberOfElements(Integer developerId) {
        int number = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT COUNT(*) AS appCount FROM DevApp WHERE userId = ?;")) {
            pstmt.setInt(1, developerId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            number = rs.getInt("appCount");

        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

    @Override
    public List<Application> findElementsForPage(Integer developerId, int page, int nbMaxElementsPerPage) {
        List<Application> apps = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM DevApp WHERE userId = ? ORDER BY appId LIMIT ?, " + nbMaxElementsPerPage + ";");
            pstmt.setInt(1, developerId);
            pstmt.setInt(2, ((page -1) * nbMaxElementsPerPage));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int appId = rs.getInt("appId");
                apps.add(loadAppli(appId));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apps;
    }

    public List<Application> findUserApplication(int userId) {
        List<Application> applications = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM Application INNER JOIN DevApp " +
                     "ON Application.appId = DevApp.appId INNER JOIN User ON " +
                     "User.userId = DevApp.userId WHERE User.userId = ? ORDER BY Application.appId ;")) {

            pstmt.setInt(1, userId);
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

    private Application loadAppliFromPublicAPIKey(String publicAPIKey) {
        Application appli = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM Application WHERE Application.appKey = ?")) {

            pstmt.setString(1, publicAPIKey);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            appli = new Application(rs.getInt("appId"), rs.getString("appName"),
                    rs.getString("appDescription"));

        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appli;
    }

    public void createAppli(int userId, Application appli) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertAppPstmt = connection.prepareStatement(
                     "INSERT INTO Application (appName, appDescription, appKey, appSecret) " +
                             "VALUES (?, ?, ?, ?);");
             PreparedStatement insertDevAppPstmt = connection.prepareStatement(
                     "INSERT INTO DevApp (userId, appId) VALUES (?, ?);")) {

            insertAppPstmt.setString(1, appli.getName());
            insertAppPstmt.setString(2, appli.getDescription());
            insertAppPstmt.setString(3, appli.getKeyUUID());
            insertAppPstmt.setString(4, appli.getSecretUUID());
            insertAppPstmt.executeUpdate();

            int appId = loadAppliFromPublicAPIKey(appli.getKeyUUID()).getId();

            insertDevAppPstmt.setInt(1, userId);
            insertDevAppPstmt.setInt(2, appId);
            insertDevAppPstmt.executeUpdate();

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
            pstmt.executeUpdate();
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
            deleteDevAppStmt.executeUpdate();
            deleteAppStmt.setInt(1, appId);
            deleteAppStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
