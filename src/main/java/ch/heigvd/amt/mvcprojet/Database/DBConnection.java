package ch.heigvd.amt.mvcprojet.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * Cette classes contient les informations (URL, user, pass) d'accès à la base de données
 * Elle permet d'initier une connexion avec cette dernière
 *
 *
 * @author D.Hamel
 * @author C.Balboni
 *
 * @version 1.0
 *
 * @date    28.03.2017 (Création)
 * @date    31.04.2017 (Finalisation v1.0)
 *
 */
public class DBConnection {

    protected static Connection con;
    private static String url = "jdbc:mysql://evodede.synology.me:3306/Projet_AMT";
    private static String  user = "Silver";
    private static String  pass = "AcYjrkoqmm2TwvdR";

    /**
     * Permet une connexion à la base de données.
     * Retourne true si la connexion est OK / False si NOK
     *
     * @return boolean
     */

    public void init() throws SQLException {
        if (this.connect()) {
            return;
        } else {
            throw new SQLException("Erreur, impossible de se connecter à la base de données !");
        }
    }

    /**
     * Classe qui fait la connexion à la base de données
     *
     * @return boolean
     */
    private boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Permet de se déconnecter à la base de données.
     * Retourne true si la connexion est OK / False si NOK
     *
     * @return boolean
     */
    protected boolean close () {
        try {
            con.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
