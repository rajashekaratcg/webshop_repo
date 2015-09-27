package com.petsupplies.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.petsupplies.model.AbstractModel;

@Entity
@Table(name = "USER_PHONES")
public class UserPhone extends AbstractModel
{

   private static final long serialVersionUID = 5032607208949119097L;

   public enum PhoneType
   {
      MOBILE, HOME, WORK, OTHER
   }

   @NotNull
   @Enumerated(EnumType.STRING)
   @Column(length = 10)
   private PhoneType type;

   @NotEmpty
   @Column(length = 100)
   private String number;

   @JsonIgnore
   @ManyToOne(optional = false)
   @JoinColumn(name = "user_id")
   private User user;

   public UserPhone()
   {

   }

   public PhoneType getType()
   {
      return type;
   }

   public void setType(PhoneType type)
   {
      this.type = type;
   }

   public String getNumber()
   {
      return number;
   }

   public void setNumber(String number)
   {
      this.number = number;
   }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((number == null) ? 0 : number.hashCode());
      result = prime * result + ((type == null) ? 0 : type.hashCode());
      result = prime * result + ((user == null) ? 0 : user.hashCode());
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

      UserPhone other = (UserPhone) obj;
      if (number == null)
      {
         if (other.number != null)
         {
            return false;
         }
      }
      else
      {
         if (!number.equals(other.number))
         {
            return false;
         }
      }

      if (type != other.type)
      {
         return false;
      }

      if (user == null)
      {
         if (other.user != null)
         {
            return false;
         }
      }
      else
      {
         if (!user.equals(other.user))
         {
            return false;
         }
      }

      return true;
   }

   @Override
   public String toString()
   {
      return "UserPhone [id=" + getId() + ", type=" + type + ", number=" + number + ", user=" + user + "]";
   }

}
