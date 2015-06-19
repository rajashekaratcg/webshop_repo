package com.petsupplies.service.user;

import java.util.List;

import com.petsupplies.model.user.User;

/**
 * User related services.
 *
 * @author rajassub (c) Jun 19, 2015, Sogeti B.V.
 */ 
public interface IUserService
{
   
   /**
    * Creates a user.
    * 
    * @param user
    * @return
    */
   User createUser(User user);

   
   /**
    * Fetches all users in system.
    * 
    * @return list of users
    */
   List<User> findAllUsers();
}
