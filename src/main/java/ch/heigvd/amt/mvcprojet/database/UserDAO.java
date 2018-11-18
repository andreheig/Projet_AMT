package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.Application;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserDAO implements IUserDAOLocal {

    @EJB
    private DevelopperDAO developperDAO;

    @EJB
    private ApplicationDAO applicationDAO;

    //@Stateless
    //protected static Connection con;
    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    @Override
    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User;")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(getUserFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        int user_id = rs.getInt("userId");
        String prenom = rs.getString("firstName");
        String nom = rs.getString("lastName");
        String email = rs.getString("email");
        String type_compte = rs.getString("accountType");
        return new User(user_id, prenom, nom, email, "", type_compte);
    }

    @Override
    public boolean userExist(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ?;")) {
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User loadUser(String userEmail) {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ?;")) {
            pstmt.setString(1, userEmail);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user = getUserFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public User loadUser(int id) {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.userId = ?;")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            user = getUserFromResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO User (firstName, lastName, email, " +
                     "password, accountType) VALUES (?, ?, ?, ?, ?);")) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getAccountType());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException();
        }
        int userID = -1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT userID FROM User WHERE firstName = ? " +
                             "AND lastName = ? AND email = ?;")) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userID = rs.getInt("userId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(userID != -1){
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Developper (userId, suspended, hasToResetPassword)" +
                         " VALUES (?, ?, ?);")) {
                pstmt.setInt(1, userID);
                pstmt.setInt(2, 0);
                pstmt.setInt(3, 0);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException();
            }
            return true;
        }
            return false;
    }

    @Override
    public boolean loginMatch(User user, String password) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ? AND User.password = ?;")) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User setUserSession(User user) {
        User ret = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ?;")) {
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("userId");
                String prenom = rs.getString("firstName");
                String nom = rs.getString("lastName");
                String email = rs.getString("email");
                String type_compte = rs.getString("accountType");
                ret = new User(user_id, prenom, nom, email, "", type_compte);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public void updatePassword(User user) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE User SET password = ? WHERE User.userId = ?;")) {
            pstmt.setString(1, user.getPassword());
            pstmt.setInt(2, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException();
        }
        developperDAO.passwordWasResetted(user.getUserId());
    }

    @Override
    public void deleteUser(User user, boolean throwExeption) {
        for (Application app : applicationDAO.findUserApplication(user.getUserId())) {
            applicationDAO.deleteAppli(app.getId());
        }
        if (throwExeption){
            throw new RuntimeException();
        }
        else {
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement deleteDevStmt = connection.prepareStatement(
                         "DELETE FROM Developper WHERE userId = ?;");
                 PreparedStatement deleteUserStmt = connection.prepareStatement(
                         "DELETE FROM User WHERE userId = ?;")) {
                deleteDevStmt.setInt(1, user.getUserId());
                deleteDevStmt.executeUpdate();
                deleteUserStmt.setInt(1, user.getUserId());
                deleteUserStmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ApplicationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int countUsers() {
        int users = -1;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS DevNumbers FROM User WHERE User.accountType = 'dev';")) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                users = rs.getInt("DevNumbers");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

}
