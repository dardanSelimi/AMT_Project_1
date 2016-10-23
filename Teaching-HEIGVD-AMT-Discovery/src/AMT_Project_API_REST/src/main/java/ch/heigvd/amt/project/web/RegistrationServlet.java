package ch.heigvd.amt.project.web;

import ch.heigvd.amt.project.model.Utils;
import ch.heigvd.amt.project.services.RegisterServiceLocal;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dardan Selimi & Romain Albasini
 */
public class RegistrationServlet extends HttpServlet {

   @EJB
   private RegisterServiceLocal registerService;

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /**
    * Handles the HTTP <code>GET</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
   }

   /**
    * Handles the HTTP <code>POST</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      //User user = null;
      String errors;

      HttpSession session = request.getSession();
      errors = registerService.registerUser(request);
      /* If no errors occured, the user's access to the login page to authentified 
         himself */
      if (errors.compareTo("") == 0) {
         response.sendRedirect("login");

      } /* Otherwise, it displays the input errors or any other errors in the 
           register page*/
      else { 
         session.setAttribute("user", null);
         session.setAttribute("errorMessage", errors);
         request.setAttribute("errorMessage", errors);
         request.getRequestDispatcher(Utils.REGISTER).forward(request, response);
      }
   }

}
