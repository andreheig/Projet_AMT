package ch.heigvd.amt.mvcprojet.Database;

import ch.heigvd.amt.mvcprojet.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBInterraction {
    // *****************************************************************************************************************
    // PARAMETRE DE LA CLASSE :

    private DBConnection db;
    private PreparedStatement stmt;

    /**
     * Liste de toutes les requêtes possibles!
     */

    private static final String SEL_USER_LOGIN = "SELECT * " +
            "FROM User " +
            "WHERE User.Email = ? " +
            " AND User.Password = ? ;";

    // *****************************************************************************************************************
    // CONSTRUCTEUR :
    public void DBInteraction() throws SQLException {
        this.db = new DBConnection();
        this.db.init();
        this.stmt = null;
    }

    private static final String EMAILEXIST = "SELECT COUNT(*) as emailExist FROM User " +
            "WHERE User.Email = ?;";

    public ArrayList<User> selUserParMailPassword(String mail, String password) throws SQLDataException, SQLException {
        this.stmt = db.con.prepareStatement(SEL_USER_LOGIN);
        this.stmt.setString(1, mail);
        this.stmt.setString(2, password);
        ResultSet rs = this.stmt.executeQuery();
        return this.creerTableauUser(rs);
    }

    public int emailExist(String mail) throws SQLDataException, SQLException{
        this.stmt = db.con.prepareStatement(EMAILEXIST);
        this.stmt.setString(1, mail);
        ResultSet rs = this.stmt.executeQuery();
        return rs.getInt("emailExist");
    }

    private ArrayList<User> creerTableauUser (ResultSet rs) throws SQLDataException, SQLException {
        ArrayList<User> data = new ArrayList<>();
        if (!rs.next()) {
            throw new SQLDataException("Aucun type d'événement ne correspond aux infos rentrées ");
        } else {
            rs.beforeFirst();
            while (rs.next()) {
                data.add(new User(rs.getInt("User_id"),
                        rs.getString("Prenom"),
                        rs.getString("Nom"),
                        rs.getString("Email"),
                        rs.getString("Type_compte")));
            }
        }
        return data;
    }
}
