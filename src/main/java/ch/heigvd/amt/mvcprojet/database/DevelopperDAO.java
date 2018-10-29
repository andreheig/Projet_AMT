package ch.heigvd.amt.mvcprojet.database;
import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.Developper;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
public class DevelopperDAO {
    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    public List<Developper> findDevelopper() {
        List<Developper> developpers = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.accountType = 'dev';");

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

                PreparedStatement loadAppsStmt = connection.prepareStatement(
                        "SELECT * FROM DevApp " +
                                "INNER JOIN Application on Application.appId = DevApp.appId " +
                                "WHERE userId = ?;");
                loadAppsStmt.setInt(1, user_id);
                ResultSet appsRS = loadAppsStmt.executeQuery();
                List<Integer> applicationsIds = new LinkedList<>();
                while(appsRS.next()) {
                    applicationsIds.add(appsRS.getInt("appId"));
                }

                developpers.add(new Developper(user_id, prenom, nom, email, "", type_compte,
                        applicationsIds, isAccountSuspended, hasToResetPassword));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return developpers;
    }

    public boolean isDeveloperSuspended(int id) {
        boolean isSuspended = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Developper WHERE Developper.userId = ?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            isSuspended = rs.getBoolean("suspended");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuspended;
    }

    public void suspendDeveloper(int id) {
        if(isDeveloperSuspended(id)) {
            throw new IllegalArgumentException("Developer id = " + id + " is already suspended.");
        }

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Developper SET suspended  = 1 WHERE Developper.userId = ?;");
            pstmt.setInt(1, id);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reactivateDeveloper(int id) {
        if(!isDeveloperSuspended(id)) {
            throw new IllegalArgumentException("Developer id = " + id + " is not currently suspended.");
        }

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Developper SET suspended  = 0 WHERE Developper.userId = ?;");
            pstmt.setInt(1, id);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetPassword(int devId) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Developper SET hasToResetPassword  = 1 WHERE Developper.userId = ?;");
            pstmt.setInt(1, devId);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void passwordWasResetted(int devId) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Developper SET hasToResetPassword  = 0 WHERE Developper.userId = ?;");
            pstmt.setInt(1, devId);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasToResetPassword(User user){
        boolean res = false;
        try {
            try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
                 PreparedStatement pstmt = connection.prepareStatement("SELECT hasToResetPassword FROM Developper WHERE Developper.userId = ?;");){
                pstmt.setInt(1, user.getUserId());
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    res = rs.getBoolean("hasToResetPassword");
                }
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
