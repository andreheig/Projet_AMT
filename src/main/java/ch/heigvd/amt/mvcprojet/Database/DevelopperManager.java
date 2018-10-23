package ch.heigvd.amt.mvcprojet.Database;
import ch.heigvd.amt.mvcprojet.model.Application;
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
public class DevelopperManager {
    @Resource(lookup = "jdbc/Projet_AMT")
    private DataSource dataSource;

    public List<User> findDevelopper() {
        List<User> developper = new ArrayList<>();
        try {
            try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
                 PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM User WHERE User.Type_compte = 'dev';");){

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int user_id = rs.getInt("User_id");
                    String prenom = rs.getString("Prenom");
                    String nom = rs.getString("Nom");
                    String email = rs.getString("Email");
                    String type_compte = rs.getString("Type_compte");
                    developper.add(new User(user_id, prenom, nom, email, "", type_compte));
                }
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return developper;
    }
}
