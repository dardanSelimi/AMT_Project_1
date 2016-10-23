package ch.heigvd.amt.project.model;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * Utility Class having some paths to certain files
 *
 * @author Dardan Selimi & Romain Albasini
 */
public final class Utils {
   public static final String LOGIN = "/WEB-INF/pages/connection.jsp";
   public static final String FIELD_FIRST_NAME = "firstName";
   public static final String FIELD_LAST_NAME = "lastName";
   public static final String FIELD_EMAIL = "email";
   public static final String FIELD_PASSWORD = "password";
   public static final String USER = "utilisateur";
   public static final String FORM = "form";
   public static final String SESSION = "sessionUtilisateur";
   public static final String VIEW = "/WEB-INF/pages/connection.jsp";
   public static final String HOME = "/WEB-INF/pages/home.jsp";
   public static final String ERROR = "/WEB-INF/pages/error.jsp";
   public static final String REGISTER = "/WEB-INF/pages/register.jsp";
   /* Maximum characters allowed in the register and login forms */
   public static final int MAX_SIZE = 25;
   /* Minimum characters allowed in the register and login forms */
   public static final int MIN_SIZE_PWD = 5;
   /* pattern used for the email. Must be like: "xxx@yyy.zzz" */
   public static final Pattern VALID_EMAIL_ADDRESS_REGEX
           = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

   /**
    * Function able to get a specific value from a form sent by the http request
    *
    * @param request
    * @param field
    * @return valeur récupérée ou null si inexistant
    */
   public static String getValueField(HttpServletRequest request, String field) {
      String value = request.getParameter(field);
      if (value == null || value.trim().length() == 0) {
         return null;
      } else {
         return value;
      }
   }
}
