package com.petsupplies.service;

import java.util.List;

import com.petsupplies.model.user.User;

public interface IUserService
{
   List<User> findAllUsers();
   
   User createUser(User user);
}
