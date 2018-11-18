package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Developper;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
@LocalBean
public class DevelopperDAO implements IPaginatedDAO, DevelopperDAOLocal {

    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    @Override
    public int getTotalNumberOfElements(Integer optionalId) {
        int number = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT COUNT(*) AS devCount FROM Developper;")) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            number = rs.getInt("devCount");

        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

    @Override
    public List<Developper> findElementsForPage(Integer optionalId, int page, int nbMaxElementsPerPage) {
        List<Developper> developers = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection()) {

            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM User WHERE User.accountType = 'dev' ORDER BY userId LIMIT ?, " + nbMaxElementsPerPage + ";");
            pstmt.setInt(1, ((page -1) * nbMaxElementsPerPage));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("userId");
                String prenom = rs.getString("firstName");
                String nom = rs.getString("lastName");
                String email = rs.getString("email");
                String type_compte = rs.getString("accountType");

                // Load dev info
                PreparedStatement loadDevStmt = connection.prepareStatement(
                        "SELECT * FROM Developper WHERE userId = ?;");
                loadDevStmt.setInt(1, user_id);
                ResultSet devRS = loadDevStmt.executeQuery();
                devRS.next();
                boolean isAccountSuspended = devRS.getBoolean("suspended");
                boolean hasToResetPassword = devRS.getBoolean("hasToResetPassword");
                loadDevStmt.close();

                PreparedStatement loadAppsStmt = connection.prepareStatement(
                        "SELECT * FROM DevApp " +
                                "INNER JOIN Application on Application.appId = DevApp.appId " +
                                "WHERE userId = ?;");
                loadAppsStmt.setInt(1, user_id);
                ResultSet appsRS = loadAppsStmt.executeQuery();
                List<Integer> applicationsIds = new LinkedList<>();
                while (appsRS.next()) {
                    applicationsIds.add(appsRS.getInt("appId"));
                }
                loadAppsStmt.close();

                developers.add(new Developper(user_id, prenom, nom, email, "", type_compte,
                        applicationsIds, isAccountSuspended, hasToResetPassword));

            }
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return developers;
    }

    @Override
    public int getNumberOfDevelopper(){
        int number = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT COUNT(*) AS dev FROM Developper;")) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            number = rs.getInt("dev");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public List<Developper> findDevelopper(int page) {
        List<Developper> developpers = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(
            "SELECT * FROM User WHERE User.accountType = 'dev' ORDER BY userId LIMIT ?, 10;");
            pstmt.setInt(1, ((page -1) * 10));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("userId");
                String prenom = rs.getString("firstName");
                String nom = rs.getString("lastName");
                String email = rs.getString("email");
                String type_compte = rs.getString("accountType");

                // Load dev info
                PreparedStatement loadDevStmt = connection.prepareStatement(
                        "SELECT * FROM Developper WHERE userId = ?;");
                loadDevStmt.setInt(1, user_id);
                ResultSet devRS = loadDevStmt.executeQuery();
                devRS.next();
                boolean isAccountSuspended = devRS.getBoolean("suspended");
                boolean hasToResetPassword = devRS.getBoolean("hasToResetPassword");
                loadDevStmt.close();

                PreparedStatement loadAppsStmt = connection.prepareStatement(
                        "SELECT * FROM DevApp " +
                                "INNER JOIN Application on Application.appId = DevApp.appId " +
                                "WHERE userId = ?;");
                loadAppsStmt.setInt(1, user_id);
                ResultSet appsRS = loadAppsStmt.executeQuery();
                List<Integer> applicationsIds = new LinkedList<>();
                while (appsRS.next()) {
                    applicationsIds.add(appsRS.getInt("appId"));
                }
                loadAppsStmt.close();

                developpers.add(new Developper(user_id, prenom, nom, email, "", type_compte,
                        applicationsIds, isAccountSuspended, hasToResetPassword));

            }
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return developpers;
    }

    @Override
    public boolean isDeveloperSuspended(int id) {
        boolean isSuspended = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT * FROM Developper WHERE Developper.userId = ?;")) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            isSuspended = rs.getBoolean("suspended");

        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return isSuspended;
    }

    @Override
    public void suspendDeveloper(int id) {
        if (isDeveloperSuspended(id)) {
            throw new IllegalArgumentException("Developer id = " + id + " is already suspended.");
        }

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Developper SET suspended  = 1 WHERE Developper.userId = ?;")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void reactivateDeveloper(int id) {
        if (!isDeveloperSuspended(id)) {
            throw new IllegalArgumentException("Developer id = " + id + " is not currently suspended.");
        }

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(
                        "UPDATE Developper SET suspended  = 0 WHERE Developper.userId = ?;")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void resetPassword(int devId, String newPassword) {
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement updateChangePwdFieldStmt = connection.prepareStatement(
                    "UPDATE Developper SET hasToResetPassword  = 1 WHERE Developper.userId = ?;");
            updateChangePwdFieldStmt.setInt(1, devId);
            updateChangePwdFieldStmt.executeUpdate();
            updateChangePwdFieldStmt.close();

            PreparedStatement updatePwdFieldStmt = connection.prepareStatement(
                    "UPDATE User SET password = ? WHERE User.userId = ?;");
            updatePwdFieldStmt.setString(1, newPassword);
            updatePwdFieldStmt.setInt(2, devId);
            updatePwdFieldStmt.executeUpdate();
            updatePwdFieldStmt.close();

        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @Override
    public void passwordWasResetted(int devId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "UPDATE Developper SET hasToResetPassword  = 0 WHERE Developper.userId = ?;")) {
            pstmt.setInt(1, devId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean hasToResetPassword(User user) {
        boolean res = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT hasToResetPassword FROM Developper WHERE Developper.userId = ?;")) {
            pstmt.setInt(1, user.getUserId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                res = rs.getBoolean("hasToResetPassword");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void addDevToApp(int devId, int appId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO DevApp (userId, appId) VALUES (?, ?);")) {
            pstmt.setInt(1, devId);
            pstmt.setInt(2, appId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DevelopperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
