/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.project.web;

import ch.heigvd.amt.project.model.User;
import ch.heigvd.amt.project.model.Utils;
import ch.heigvd.amt.project.services.ConnectionLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConnectionServlet extends HttpServlet {

   @EJB
   private ConnectionLocal connection;

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /* Displaying the login page */
      request.getSession().setAttribute("message", null);
      this.getServletContext().getRequestDispatcher(Utils.LOGIN).forward(request, response);
   }

   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      User user = null;
      // Récupération de la session depuis la requête 
      HttpSession session = request.getSession();
      String msg;

      if ((user = connection.connectUser(request)) != null) {
        // msg = "Servlet Login succeded!";
         session.setAttribute("user", user);
         response.sendRedirect("home");
      } else {
         msg = "Login failed! The email or password is wrong";
         request.setAttribute("errorMessage", msg);
         session.setAttribute("user", null);
         request.getRequestDispatcher(Utils.LOGIN).forward(request, response);
      }
   }
}