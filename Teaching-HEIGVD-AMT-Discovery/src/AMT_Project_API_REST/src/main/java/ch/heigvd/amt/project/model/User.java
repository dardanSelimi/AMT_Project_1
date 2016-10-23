package ch.heigvd.amt.project.model;

/**
 * Class User représenting a user 
 * @author Dardan Selimi & Romain Albasini
 */
public class User {

   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private long id;

   /**
    *
    * @param firstName
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    *
    * @param lastName
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    *
    * @return
    */
   public long getId() {
      return id;
   }

   /**
    *
    * @param id
    */
   public void setId(long id) {
      this.id = id;
   }

   /**
    *
    * @return email
    */
   public String getEmail() {
      return email;
   }

   /**
    *
    * @param email
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    *
    * @return password
    */
   public String getPassword() {
      return password;
   }

   /**
    *
    * @param password
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * Constructor
    */
   public User() {}

   /**
    * Constructor
    * @param firstName
    * @param lastName
    * @param email
    * @param password
    * @param id
    */
   public User(String firstName, String lastName, String email, String password, long id) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
      this.id = id;
   }

   /**
    * Constructor
    * @param firstName
    * @param lastName
    * @param email
    * @param password
    */
   public User(String firstName, String lastName, String email, String password) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password = password;
   }

   /**
    * Constructor
    * @param firstName
    * @param lastName
    */
   public User(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   /**
    *
    * @return firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    *
    * @return lastName
    */
   public String getLastName() {
      return lastName;
   }
   /* JSON style display of the User object. Used for debugging */
   @Override
   public String toString() {
      return "Person{ " + " firstName=" + firstName + ", lastName=" + lastName + ", email = " + email + "password= " + password + " }";
   }
}
