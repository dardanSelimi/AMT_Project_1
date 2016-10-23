
package ch.heigvd.amt.project.services;

import ch.heigvd.amt.project.model.User;
import ch.heigvd.amt.project.model.Utils;
import ch.heigvd.amt.project.services.dao.UserManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
/***
 * 
 * @author Dardan Selimi & Romain Albasini
 */
@Stateless
public class Connect implements ConnectionLocal {

   @EJB
   private UserManagerLocal usersManager;

   @Override
   public User connectUser(HttpServletRequest request) {
      /* Get fields from login form */
      String email = Utils.getValueField(request, Utils.FIELD_EMAIL);
      String password = Utils.getValueField(request, Utils.FIELD_PASSWORD);
      String errorMsg = checkLoginInputs(email, password);
      /* Check if there are any format errors*/
      if (errorMsg.compareTo("") != 0) {
         request.setAttribute("errorMessage", errorMsg);
         return null;
      }
      /* Check if the user exists, return the user if so*/
      if (usersManager.checkLogin(email, password)) {
         return usersManager.getUser(email, "email");
      } else {
         return null;
      }
   
}
/***
 * Check the input format of the login fields
 * @param email
 * @param password
 * @return the input format errors
 */
private String checkLoginInputs(String email, String password) {
      String errorMsg = "";
      if (!usersManager.checkEmailFormat(email)
              || !usersManager.checkField(email, Utils.MAX_SIZE)
              && usersManager.checkField(email, Utils.MIN_SIZE_PWD)) {
         errorMsg += "Email format is wrong. Must be between 0 and 25 caracters and xxx@yyy.zzz\n";
      }
      if (!usersManager.checkField(password, Utils.MAX_SIZE)
              || usersManager.checkField(password, Utils.MIN_SIZE_PWD)) {
         errorMsg += "Password format is wrong. Must be between 0 and 25 caracters\n";
      }
      return errorMsg;
   }
}
