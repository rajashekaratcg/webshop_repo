package com.petsupplies.service.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.petsupplies.model.role.Role;
import com.petsupplies.model.user.User;
import com.petsupplies.model.user.UserAddress;
import com.petsupplies.model.user.UserPhone;
import com.petsupplies.repository.category.RoleRepository;
import com.petsupplies.repository.user.UserRepository;

@Service("userService")
@Transactional
public class UserService implements IUserService
{
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private RoleRepository roleRepository;

   @Override
   public List<User> findAllUsers()
   {
      return (List<User>) userRepository.findAll();
   }

   @Override
   public User createUser(User user)
   {
      processPassword(user);
      populateWithUser(user);
      populateUserRole(user);
      return userRepository.save(user);
   }

   private void processPassword(User user)
   {
      String salt = "petsupplies.com";       
      user.setPassword((new ShaPasswordEncoder(256)).encodePassword(user.getPassword(), salt));
   }

   private void populateUserRole(User user)
   {
      user.setRoles(Lists.newArrayList(roleRepository.findByName(Role.Roles.ROLE_USER.name())));
   }

   private void populateWithUser(User user)
   {
      for (UserAddress address : user.getUserAddress())
      {
         address.setUser(user);
      }

      for (UserPhone phone : user.getUserPhones())
      {
         phone.setUser(user);
      }
   }

   @Override
   public User findByUsername(String username)
   {
      return userRepository.findByUsername(username);
   }

}
