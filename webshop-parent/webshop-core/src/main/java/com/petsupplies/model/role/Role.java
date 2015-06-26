package com.petsupplies.model.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;
import com.petsupplies.model.user.User;

@Entity
@Table(name = "ROLES")
public class Role
{

   public enum Roles {
      ROLE_USER,ROLE_ADMIN;
   }
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(length = 100)
   private String name;

   @ManyToMany(mappedBy = "roles")
   private List<User> users = Lists.newArrayList();

   public Role()
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

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public List<User> getUsers()
   {
      return users;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      Role other = (Role) obj;
      if (name == null)
      {
         if (other.name != null)
         {
            return false;
         }
      }
      else if (!name.equals(other.name))
      {
         return false;
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder builder = new StringBuilder();
      builder.append("Role [id=");
      builder.append(id);
      builder.append(", name=");
      builder.append(name);
      builder.append("]");
      return builder.toString();
   }

}
