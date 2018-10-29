package ch.heigvd.amt.mvcprojet.database;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UserDAO {

    @EJB
    private DevelopperDAO developperDAO;

    //@Stateless
    //protected static Connection con;
    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        try {
            try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User;");){
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    users.add(getUserFromResultSet(rs));
                }
                pstmt.close();
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

    public boolean userExist(User user){
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ?;");){
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
            pstmt.close();

    } catch (SQLException ex) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
    }

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

    public boolean insertUser(User user){
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO User (firstName, lastName, email, " +
                     "password, accountType) VALUES (?, ?, ?, ?, ?);");){
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getAccountType());
            ResultSet rs = pstmt.executeQuery();
        }
             catch (SQLException  ex){
                 Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
        return false;
    }

    public boolean loginMatch(User user, String password) {
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ? AND User.password = ?;");){
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public User setUserSession(User user){
        User ret = null;
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.email = ?;");){
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int user_id = rs.getInt("userId");
                String prenom = rs.getString("firstName");
                String nom = rs.getString("lastName");
                String email = rs.getString("email");
                String type_compte = rs.getString("accountType");
                ret = new User(user_id, prenom, nom, email, "", type_compte);
            }
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public void updatePassword(User user){
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE User SET password = ? WHERE User.userId = ?;");
            pstmt.setString(1, user.getPassword());
            pstmt.setInt(2, user.getUserId());
            ResultSet rs = pstmt.executeQuery();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        developperDAO.passwordWasResetted(user.getUserId());
    }
}