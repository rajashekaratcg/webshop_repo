package com.petsupplies.model.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.collect.Lists;
import com.petsupplies.model.role.Role;

@Entity
@Table(name = "USERS")
public class User
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @NotEmpty
   @Column(length = 100, unique = true)
   private String username;
   @NotEmpty
   @Column(length = 200)
   private String password;
   @NotEmpty
   @Column(name = "full_name", length = 255)
   private String fullName;
   @Email
   @Column(length = 255)
   private String email;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
   private List<UserPhone> userPhones = Lists.newArrayList();

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
   private List<UserAddress> userAddress = Lists.newArrayList();

   @ManyToMany
   @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
   private List<Role> roles = Lists.newArrayList();

   public User()
   {
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getFullName()
   {
      return fullName;
   }

   public void setFullName(String fullName)
   {
      this.fullName = fullName;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public List<UserPhone> getUserPhones()
   {
      return userPhones;
   }

   public void setUserPhones(List<UserPhone> userPhones)
   {
      this.userPhones.clear();
      this.userPhones.addAll(userPhones);
   }

   public List<UserAddress> getUserAddress()
   {
      return userAddress;
   }

   public void setUserAddress(List<UserAddress> userAddress)
   {
      this.userAddress = userAddress;
   }

   public List<Role> getRoles()
   {
      return roles;
   }

   public void setRoles(List<Role> roles)
   {
      this.roles = roles;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((username == null) ? 0 : username.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (obj == null)
      {
         return false;
      }
      if (getClass() != obj.getClass())
      {
         return false;
      }
      User other = (User) obj;
      if (username == null)
      {
         if (other.username != null)
         {
            return false;
         }
      }
      else if (!username.equals(other.username))
      {
         return false;
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder builder = new StringBuilder();
      builder.append("User [id=");
      builder.append(id);
      builder.append(", username=");
      builder.append(username);
      builder.append(", password=");
      builder.append(password);
      builder.append(", fullName=");
      builder.append(fullName);
      builder.append(", email=");
      builder.append(email);
      builder.append("]");
      return builder.toString();
   }

}
