package ch.heigvd.amt.mvcprojet.database;

import ch.heigvd.amt.mvcprojet.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IUserDAOLocal {

     List<User> findAllUser();

    //private User getUserFromResultSet(ResultSet rs) throws SQLException;

     boolean userExist(User user);

     User loadUser(String userEmail);

     User loadUser(int id);

     boolean insertUser(User user);

     boolean loginMatch(User user, String password);

     User setUserSession(User user);

     void updatePassword(User user);

     void deleteUser(User user, boolean throwExeption);

     int countUsers();
}
