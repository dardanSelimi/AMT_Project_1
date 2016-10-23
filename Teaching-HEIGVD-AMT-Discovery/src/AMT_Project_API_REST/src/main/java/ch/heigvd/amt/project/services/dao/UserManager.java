package ch.heigvd.amt.project.services.dao;

import ch.heigvd.amt.project.model.User;
import ch.heigvd.amt.project.model.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
/**
 * 
 * @author Dardan Selimi & Romain Albasini
 */
@Stateless
public class UserManager implements UserManagerLocal {

   @Resource(lookup = "jdbc/users")
   private DataSource dataSource;
   /***
    * 
    * @param user
    * @return 
    */
   @Override
   public User insertUser(User user) {
      String sql = "INSERT INTO user VALUES (NULL,'" + user.getFirstName() + "','" 
              + user.getLastName() + "','" + user.getEmail() + "','" 
              + user.getPassword() + "');";
      try {
         try (Connection connection = dataSource.getConnection()) {

            PreparedStatement psmt = connection.prepareStatement(sql);
            if (psmt.executeUpdate() > 0) {
               System.out.println("User added");
            } else {
               System.out.println("User not added. A problem has occured!");
            }
            connection.close();
            return user;
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
   }
   /***
    * 
    * @param value
    * @param field
    * @return 
    */
   @Override
   public User getUser(String value, String field) {
      String sql = "Select * From user Where " + field + " = '" + value + "';";
      User user = null;
      try {
         try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = null;
            if ((rs = psmt.executeQuery()) != null) {
               user = new User();
               while (rs.next()) {
                  user.setFirstName(rs.getString("firstName"));
                  user.setLastName(rs.getString("lastName"));
                  user.setEmail(rs.getString("email"));
                  user.setPassword(rs.getString("_password"));
                  user.setId(rs.getLong("id"));
               }
            }
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return user;
   }
   /***
    * 
    * @return 
    */
   @Override
   public List<User> getAllUsers() {
      List<User> users = new ArrayList<>();
      String sql = "Select * From user;";
      try {
         try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
               String firstName = rs.getString("firstName");
               String lastName = rs.getString("lastName");
               String email = rs.getString("email");
               String password = rs.getString("_password");
               long id = rs.getLong("id");

               users.add(new User(firstName, lastName, email, password, id));
            }
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return users;
   }
   /***
    * 
    * @param lastName
    * @return 
    */
   @Override
   public boolean removeUser(String lastName) {
      String sql = "DELETE FROM user WHERE lastName = '" + lastName + "';";

      boolean result = false;
      try {
         try (Connection connection = dataSource.getConnection()) {
            PreparedStatement psmt = connection.prepareStatement(sql);

            if (psmt.executeUpdate() > 0) {
               result = !result;
            }
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return result;
   }
   /***
    * 
    * @param email
    * @return 
    */
   @Override
   public boolean checkEmail(String email) {
      return getUser(email, "email").getLastName() != null;
   }
   /***
    * 
    * @param password
    * @return 
    */
   @Override
   public boolean checkPassword(String password) {
      return getUser(password, "_password").getPassword() != null;
   }
   /***
    * Check one field's size. For the size information, see the the class Utils
    * @param field
    * @param size
    * @return 
    */
   @Override
   public boolean checkField(String field, int size) {
      return field.length() <= size;
   }
   /***
    * Match the 
    * @param email
    * @return 
    */
   @Override
   public boolean checkEmailFormat(String email) {
      Matcher matcher = Utils.VALID_EMAIL_ADDRESS_REGEX.matcher(email);
      return matcher.find();
   }
   /***
    * Check the existence of the user trying to get access in the database
    * @param email
    * @param password
    * @return
    */
   @Override
   public boolean checkLogin(String email, String password) {
      String sql = "Select * From user Where email = '" + email + "' AND _password = '" + password + "';";
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement psmt = connection.prepareStatement(sql);
         ResultSet rs = psmt.executeQuery();
         return rs.next();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
   }
}
