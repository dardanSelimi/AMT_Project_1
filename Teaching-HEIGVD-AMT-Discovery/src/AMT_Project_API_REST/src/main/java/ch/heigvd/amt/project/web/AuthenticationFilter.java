package ch.heigvd.amt.project.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Dardan Selimi & Romain Albasini
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

   private ServletContext context;

   @Override
   public void init(FilterConfig fConfig) throws ServletException {
      this.context = fConfig.getServletContext();
      this.context.log("AuthenticationFilter initialized");
   }
   /**
    * Filter 
    * @param request
    * @param response
    * @param chain
    * @throws IOException
    * @throws ServletException 
    */
   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");

      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse res = (HttpServletResponse) response;
      String uri = req.getRequestURI().substring(req.getContextPath().length());

      this.context.log("Requested Resource::" + uri);
      /* if the user is not authentified, the filter redirects automatically to the index page */
      if (uri.contentEquals("/")) {
         res.sendRedirect("index.jsp");
         return;
      }
      /* if the user is authentified, he can access the pages he wants */
      if (req.getSession().getAttribute("user") != null) {
         switch (uri) {
            case "/login":
               res.sendRedirect("home");
               break;
            case "/register":
               res.sendRedirect("register");
               break;
            default:
               chain.doFilter(request, response);
               break;
         }
         /* Since home is the protected page for authentified users, the only way to
         access this page is having a session and consequently, having been 
         authentified. Otherwise, the filter redirects the user to the login page */
      } else if (uri.contentEquals("/home")) {
         res.sendRedirect("login");
      } else {
         chain.doFilter(request, response);
      }
   }

   @Override
   public void destroy() {}

}
