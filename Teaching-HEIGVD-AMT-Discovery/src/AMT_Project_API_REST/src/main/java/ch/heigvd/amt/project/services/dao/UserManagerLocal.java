package ch.heigvd.amt.project.services.dao;

import ch.heigvd.amt.project.model.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserManagerLocal {

   public User insertUser(User person);

   public User getUser(String value, String field);

   public List<User> getAllUsers();

   public boolean removeUser(String fn);

   public boolean checkEmail(String email);

   public boolean checkPassword(String password);

   public boolean checkField(String field, int size);

   public boolean checkEmailFormat(String email);
   
   public boolean checkLogin(String email, String password);

}
