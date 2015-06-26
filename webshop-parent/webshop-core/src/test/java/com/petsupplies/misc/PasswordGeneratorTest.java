package com.petsupplies.misc;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneratorTest
{

   @Ignore
   public void testBCryptHash()
   {
      String password = "user";
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();      
      String hashedPassword = passwordEncoder.encode(password);
      
      assertNotEquals(password, hashedPassword);
      assertTrue(hashedPassword.length() == 60);
      
      System.out.println(hashedPassword);
      // admin $2a$10$eABcgK6hW/raTKARk.Um0uDDA.ssleyPhzeOC7SCq0ryQTwvFPiJa
      // user $2a$10$6FiCv/U39/zE64j3Rd0tX.WT0rqGwpSQOWi/6IYtY2Y8uJX9.Wgs.
   }


   @Test
   public void testSha256Hash()
   {
      String password = "admin";
      String salt = "petsupplies.com";
      ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);      
      String hashedPassword = passwordEncoder.encodePassword(password, salt);
      
      assertNotEquals(password, hashedPassword);
      
      System.out.println(hashedPassword);
      System.out.println(hashedPassword.length());
      // admin 186c5916da9f5e0c7938882df27873a05ceb8ad3de80b2c3555943c77ee510cd
      // user 9530680590a7e2a20bd96d0a80510d92019119af7e61d5fb314ef4c7422e6a64
   }
}
