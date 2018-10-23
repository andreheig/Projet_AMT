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
        try {
            try (Connection connection = dataSource.getConnection(); /*PreparedStatement pstmt = connection.prepareStatement("");) {*/
                 PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Application INNER JOIN Developper " +
                         "ON Application.Application_id = Developper.Application_id INNER JOIN User ON " +
                         "User.User_id = Developper.User_id WHERE User.User_id = ?;");){
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int user_id = rs.getInt("Application_id");
                    String nom = rs.getString("Nom");
                    String description = rs.getString("Description");
                    applications.add(new Application(user_id, nom, description));
                }
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return applications;
    }

}
