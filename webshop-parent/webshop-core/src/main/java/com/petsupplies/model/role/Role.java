package com.petsupplies.model.role;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.petsupplies.model.AbstractModel;
import com.petsupplies.model.user.User;

@Entity
@Table(name = "ROLES")
public class Role extends AbstractModel
{
   private static final long serialVersionUID = -6219151565590134617L;

   public enum Roles {
      ROLE_USER,ROLE_ADMIN;
   }
   
   @Column(length = 100)
   private String name;

   @JsonIgnore
   @ManyToMany(mappedBy = "roles")
   private List<User> users = Lists.newArrayList();

   public Role()
   {

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
      builder.append(this.getId());
      builder.append(", name=");
      builder.append(this.name);
      builder.append("]");
      return builder.toString();
   }

}
