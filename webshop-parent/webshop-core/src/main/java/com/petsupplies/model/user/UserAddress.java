package com.petsupplies.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESSES")
public class UserAddress {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(length = 1000)
   private String address;

   @Column(length = 100)
   private String city;

   @Column(length = 100)
   private String state;

   @Column(length = 50)
   private String zipcode;

   @Column(length = 100)
   private String country;

   @ManyToOne(optional = false)
   @JoinColumn(name = "user_id")
   private User user;

   protected UserAddress() {

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((address == null) ? 0 : address.hashCode());
      result = prime * result + ((city == null) ? 0 : city.hashCode());
      result = prime * result + ((country == null) ? 0 : country.hashCode());
      result = prime * result + ((state == null) ? 0 : state.hashCode());
      result = prime * result + ((user == null) ? 0 : user.hashCode());
      result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      UserAddress other = (UserAddress) obj;
      if (address == null) {
         if (other.address != null) {
            return false;
         }
      } else if (!address.equals(other.address)) {
         return false;
      }
      if (city == null) {
         if (other.city != null) {
            return false;
         }
      } else if (!city.equals(other.city)) {
         return false;
      }
      if (country == null) {
         if (other.country != null) {
            return false;
         }
      } else if (!country.equals(other.country)) {
         return false;
      }
      if (state == null) {
         if (other.state != null) {
            return false;
         }
      } else if (!state.equals(other.state)) {
         return false;
      }
      if (user == null) {
         if (other.user != null) {
            return false;
         }
      } else if (!user.equals(other.user)) {
         return false;
      }
      if (zipcode == null) {
         if (other.zipcode != null) {
            return false;
         }
      } else if (!zipcode.equals(other.zipcode)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("UserAddress [address=");
      builder.append(address);
      builder.append(", city=");
      builder.append(city);
      builder.append(", state=");
      builder.append(state);
      builder.append(", zipcode=");
      builder.append(zipcode);
      builder.append(", country=");
      builder.append(country);
      builder.append(", user=");
      builder.append(user);
      builder.append("]");
      return builder.toString();
   }

}
