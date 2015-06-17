package com.petsupplies.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsupplies.model.user.User;
import com.petsupplies.repository.UserRepository;

@Service("userService")
@Transactional
public class UserService implements IUserService
{
   @Autowired
   private UserRepository userRepository;

   @Override
   public List<User> findAllUsers()
   {
      return (List<User>) userRepository.findAll();
   }

   @Override
   public User createUser(User user)
   {
      return userRepository.save(user);
   }

}
