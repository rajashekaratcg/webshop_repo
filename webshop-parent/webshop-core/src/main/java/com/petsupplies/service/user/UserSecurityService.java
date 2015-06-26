/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rajassub
 ** Copyright: (c) Jun 24, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.petsupplies.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.petsupplies.model.role.Role;
import com.petsupplies.repository.category.RoleRepository;
import com.petsupplies.repository.user.UserRepository;

/**
 * User services specifically catering to security needs. This is a custom implementation of {@link UserDetailsService}
 *
 * @author rajassub (c) Jun 24, 2015, Sogeti B.V.
 */
@Service("userSecurityService")
@Transactional(readOnly = true)
public class UserSecurityService implements UserDetailsService
{
   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      com.petsupplies.model.user.User user = userRepository.findByUsername(username);
      boolean isEnabled = true;
      boolean isAccountNonExpired = true;
      boolean isCredentialsNonExpired = true;
      boolean isAccountNonLocked = true;

      List<GrantedAuthority> authorityList = getGrantedAuthorities(getRoleNames(user.getRoles()));

      return new User(user.getUsername(), user.getPassword().toLowerCase(), isEnabled, isAccountNonExpired, isCredentialsNonExpired, isAccountNonLocked, authorityList);
   }

   private List<String> getRoleNames(List<Role> roles)
   {
      List<String> roleNames = Lists.newArrayList();
      for (Role role : roles)
      {
         roleNames.add(role.getName());
      }
      return roleNames;
   }

   private List<GrantedAuthority> getGrantedAuthorities(List<String> roles)
   {
      List<GrantedAuthority> authorities = Lists.newArrayList();
      for (String role : roles)
      {
         authorities.add(new SimpleGrantedAuthority(role));
      }
      return authorities;
   }

}
