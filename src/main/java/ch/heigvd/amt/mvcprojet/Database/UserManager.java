package ch.heigvd.amt.mvcprojet.Database;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

@Stateless
public class UserManager {

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
                    int user_id = rs.getInt("User_id");
                    String prenom = rs.getString("Prenom");
                    String nom = rs.getString("Nom");
                    String email = rs.getString("Email");
                    String type_compte = rs.getString("Type_compte");
                    users.add(new User(user_id, prenom, nom, email, "", type_compte));
                }
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public boolean userExist(User user){
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.Email = ?;");){
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return false;
            }
            else{
                insertUser(user);
            }
            pstmt.close();

    } catch (SQLException ex) {
        Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return true;
    }

    private boolean insertUser(User user){
        try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO User (Prenom, Nom, Email, " +
                     "Password, Type_compte) VALUES (?, ?, ?, ?, ?);");){
            pstmt.setString(1, user.getPrenom());
            pstmt.setString(2, user.getNom());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getType_compte());
            ResultSet rs = pstmt.executeQuery();
        }
             catch (SQLException  ex){
                 Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
             }
        return false;
    }

}
