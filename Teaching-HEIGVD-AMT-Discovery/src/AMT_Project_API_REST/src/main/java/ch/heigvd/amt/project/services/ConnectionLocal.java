/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.project.services;

import ch.heigvd.amt.project.model.User;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;


@Local
public interface ConnectionLocal {
      public User connectUser(HttpServletRequest request);

}
