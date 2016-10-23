package ch.heigvd.amt.project.rest;

import ch.heigvd.amt.project.model.User;
import ch.heigvd.amt.project.model.Utils;
import ch.heigvd.amt.project.rest.dto.UserDTO;
import ch.heigvd.amt.project.services.dao.UserManagerLocal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/**
 * API REST
 *
 * @author Dardan Selimi & Romain Albasini
 */
@Stateless
@Path("/people")
public class UserResource {

   @EJB
   private UserManagerLocal userManager;

   @Context
   UriInfo uriInfo;

   /**
    * *
    * GET request for a all the users
    *
    * @param byName
    * @return a DTO representation of the users (first and last only)
    */
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<UserDTO> getPeople(@QueryParam(value = "byName") String byName) {
      List<User> users = userManager.getAllUsers();
      List<UserDTO> usersDTO = new ArrayList<>();
      for (User user : users) {
         usersDTO.add(toDTO(user));
      }
      return usersDTO;

   }

   /**
    * *
    * POST request to add a user in the database
    *
    * @param user a JSON object of a user
    * @return specific repsonse depending on errors occurred or not.
    */
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createUser(User user) {
      /* Empty fileds errors */
      if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()
              || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
         return Response
                 .notModified("All fields must be filled!")
                 .build();
      }
      /* The email input by the user has a the wrong format */
      if (!userManager.checkEmailFormat(user.getEmail())
              || !userManager.checkField(user.getEmail(), Utils.MAX_SIZE)
              && userManager.checkField(user.getEmail(), Utils.MIN_SIZE_PWD)) {
         return Response
                 .notModified("The email format is wrong!")
                 .build();
      }
      /* Wrong size for the password input. Check the Utils class for more 
         information about the allowed size */
      if (!userManager.checkField(user.getPassword(), Utils.MAX_SIZE)
              || userManager.checkField(user.getPassword(), Utils.MIN_SIZE_PWD)) {
         return Response
                 .notModified("The password size is wrong! It must be between "
                         + Utils.MIN_SIZE_PWD + " and " + Utils.MAX_SIZE + ".")
                 .build();
      }
      /* If no errors occured, the users is created */
      if (userManager.getUser(user.getEmail(), "email").getEmail() == null) {
         userManager.insertUser(user);
         URI href = uriInfo
                 .getBaseUriBuilder()
                 .path(UserResource.class)
                 .path(UserResource.class, "getPerson")
                 .build(user.getLastName());

         return Response
                 .created(href)
                 .build();
      } /* Last case: the email input already exists in the database */ else {
         return Response
                 .notModified("The email already exists!")
                 .build();
      }
   }

   /**
    * *
    * GET request for a specific user
    *
    * @param lastName the last name for which a client want to get the user data
    * @return a DTO representation of the user (first and last only)
    */
   @Path("{lastName}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public UserDTO getPerson(@PathParam(value = "lastName") String lastName) {
      User person = userManager.getUser(lastName, "lastName");
      return toDTO(person);
   }

   /**
    * DELETE request for a specific user
    *
    * @param lastName to proceed the deletion
    * @return a DTO representation of the user (first and last only)
    */
   @DELETE
   @Path("{lastName}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public UserDTO deletePerson(@PathParam(value = "lastName") String lastName) {
      User user = userManager.getUser(lastName, "lastName");
      System.out.println(user);
      if (userManager.removeUser(lastName)) {
         return toDTO(user);
      }
      return toDTO(user);
   }

   /**
    * *
    * UPADTE request
    *
    * @param lastName
    * @param toChange
    * @return DTO representation of the user
    */
   @PUT
   @Path("{lastName}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public UserDTO updatePerson(@PathParam(value = "lastName") String lastName,
           User toChange) {
      User user = userManager.getUser(lastName, "lastName");
      System.out.println(user);
      if (user.getLastName().compareTo("") != 0) {
         return new UserDTO("Unknown", "Unknown", "User doesn't exists");
      }
      if (user.getEmail().compareTo(toChange.getEmail()) == 0) {
         return new UserDTO("Unknown", "Unknown", "Email already exists");

      }
      userManager.removeUser(lastName);
      user.setFirstName(toChange.getFirstName());
      user.setLastName(toChange.getLastName());
      user.setEmail(toChange.getEmail());
      user.setPassword(toChange.getPassword());
      userManager.insertUser(user);
      return toDTO(user);
   }

   /**
    * *
    * Convert a DTO user into a full User
    *
    * @param dto
    * @return the full User
    */
   public User fromDTO(UserDTO dto) {
      return userManager.getUser(dto.getLastName(), "lastName");
   }

   /**
    * *
    * Convert a full user into its DTO representation (first name and last name only
    * are exposed)
    *
    * @param user
    * @return the DTO representation of the user
    */
   public UserDTO toDTO(User user) {
      return new UserDTO(user.getFirstName(), user.getLastName());
   }
}
