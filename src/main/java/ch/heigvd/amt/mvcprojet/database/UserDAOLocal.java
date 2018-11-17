package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Local
public interface UserDAOLocal {

    public List<User> findAllUser();

    //private User getUserFromResultSet(ResultSet rs) throws SQLException;

    public boolean userExist(User user);

    public User loadUser(String userEmail);

    public User loadUser(int id);

    public boolean insertUser(User user);

    public boolean loginMatch(User user, String password);

    public User setUserSession(User user);

    public void updatePassword(User user);

    //private int getLastInseredID();
}
