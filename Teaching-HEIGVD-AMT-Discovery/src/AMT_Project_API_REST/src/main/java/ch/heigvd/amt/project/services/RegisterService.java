package ch.heigvd.amt.project.services;

import ch.heigvd.amt.project.model.User;
import ch.heigvd.amt.project.model.Utils;
import ch.heigvd.amt.project.services.dao.UserManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dardan Selimi & Romain Albasini
 */
@Stateless
public class RegisterService implements RegisterServiceLocal {

   @EJB
   private UserManagerLocal usersManager;
   
   @Override
   public String registerUser(HttpServletRequest request) {
      String firstName = Utils.getValueField(request, Utils.FIELD_FIRST_NAME);
      String lastName = Utils.getValueField(request, Utils.FIELD_LAST_NAME);
      String email = Utils.getValueField(request, Utils.FIELD_EMAIL);
      String password = Utils.getValueField(request, Utils.FIELD_PASSWORD);
      String errors = "";
      /* Checking the input format */
      if((errors = checkFields(firstName,lastName,email,password)).compareTo("") != 0){
         return errors;
      }
      /* An existing email (in the database) cannot be used to create an account, so
        test its existence*/
      if (!usersManager.checkEmail(email)) { // email ne doit pas exister
         User newUser = new User(firstName, lastName, email, password);
         usersManager.insertUser(newUser);
         return "";
      } else return "Email already exists";
   }
   /***
    * 
    * @param firstName
    * @param lastName
    * @param email
    * @param password
    * @return the errors of input formats
    */
   private String checkFields(String firstName, String lastName, String email, String password) {
      String errorMsg = "";
      /* Email field*/
      if (!usersManager.checkEmailFormat(email)
              || !usersManager.checkField(email, Utils.MAX_SIZE)
              && usersManager.checkField(email, Utils.MIN_SIZE_PWD)) {
         errorMsg += "Email format is wrong. Must be between 0 and 25 caracters and xxx@yyy.zzz\n";
      }
      /* Password field */
      if (!usersManager.checkField(password, Utils.MAX_SIZE)
              || usersManager.checkField(password, Utils.MIN_SIZE_PWD)) {
         errorMsg += "Password format is wrong. Must be between 0 and 25 caracters\n";

      }
      /* First Name field */
      if (!usersManager.checkField(firstName, Utils.MAX_SIZE)
              || usersManager.checkField(firstName, Utils.MIN_SIZE_PWD)) {
         errorMsg += "The first name format is wrong. Must be between 0 and 25 caracters\n";

      }
      /* Last Name field */
      if (!usersManager.checkField(lastName, Utils.MAX_SIZE)
              || usersManager.checkField(lastName, Utils.MIN_SIZE_PWD)) {
         errorMsg += "The last name format is wrong. Must be between 0 and 25 caracters\n";
      }
      return errorMsg;
   }
}
