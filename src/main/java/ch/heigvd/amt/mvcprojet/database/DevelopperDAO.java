package ch.heigvd.amt.mvcprojet.database;
import ch.heigvd.amt.mvcprojet.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Stateless
public class DevelopperDAO {
    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    public List<User> findDevelopper() {
        List<User> developper = new ArrayList<>();
        try {
            try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
                 PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.accountType = 'dev';");){

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int user_id = rs.getInt("userId");
                    String prenom = rs.getString("firstName");
                    String nom = rs.getString("lastName");
                    String email = rs.getString("email");
                    String type_compte = rs.getString("accountType");
                    developper.add(new User(user_id, prenom, nom, email, "", type_compte));
                }
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return developper;
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
