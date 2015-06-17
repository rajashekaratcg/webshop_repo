package com.petsupplies.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_PHONES")
public class UserPhone
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   public enum PhoneType {
      MOBILE,HOME,WORK,OTHER
   }

   @Enumerated(EnumType.STRING)
   @Column(length=10)
   private PhoneType type;
   
   @Column(length=100)
   private String number;
   
   @ManyToOne(optional=false)
   @JoinColumn(name="user_id")
   private User user;
   
   protected UserPhone() {
      
   }
   
   
}
