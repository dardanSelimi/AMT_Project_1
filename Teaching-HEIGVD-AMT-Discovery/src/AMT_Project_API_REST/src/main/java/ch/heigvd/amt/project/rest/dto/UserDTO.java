package ch.heigvd.amt.project.rest.dto;

import javax.xml.bind.annotation.XmlElement;

/**
 * Classe DTO
 *
 * @author Dardan Selimi & Romain Albasini
 */
public class UserDTO {

   @XmlElement(name = "firstName")
   private String firstName;
   @XmlElement(name = "lastName")
   private String lastName;
   private String message;

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public UserDTO() {
   }

   /**
    * Constructor
    *
    * @param firstName
    * @param lastName
    */
   public UserDTO(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public UserDTO(String firstName, String lastName, String message) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.message = message;
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
    * @param firstName
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    *
    * @return lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    *
    * @param lastName
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

}
