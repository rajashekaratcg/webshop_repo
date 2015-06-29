package com.petsupplies.model.order;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.collect.Lists;
import com.petsupplies.model.AbstractModel;
import com.petsupplies.model.user.User;

@Entity
@Table(name = "ORDERS")
public class Order extends AbstractModel
{

   private static final long serialVersionUID = -7649395512770160357L;

   public enum Status
   {
      PLACED, FAILED, SHIPPED, DELIVERED
   }

   @ManyToOne(optional = false)
   @JoinColumn(name = "user_id")
   private User user;

   @Column(name = "order_no", length = 60, nullable = false, updatable = false, unique = true)
   private String orderNumber;

   @Column(name = "date", nullable = false)
   @Temporal(TemporalType.DATE)
   private Date orderDate;

   @Embedded
   @AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "billing_address", length = 1000)),
         @AttributeOverride(name = "city", column = @Column(name = "billing_city", length = 100)), @AttributeOverride(name = "state", column = @Column(name = "billing_state", length = 100)),
         @AttributeOverride(name = "zipcode", column = @Column(name = "billing_zipcode", length = 100)), @AttributeOverride(name = "country", column = @Column(name = "billing_country", length = 100)) })
   private Address billingAddress;

   @Embedded
   @AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "shipping_address", length = 1000)),
         @AttributeOverride(name = "city", column = @Column(name = "shipping_city", length = 100)), @AttributeOverride(name = "state", column = @Column(name = "shipping_state", length = 100)),
         @AttributeOverride(name = "zipcode", column = @Column(name = "shipping_zipcode", length = 100)),
         @AttributeOverride(name = "country", column = @Column(name = "shipping_country", length = 100)) })
   private Address shippingAddress;

   @Enumerated(EnumType.STRING)
   @Column(name = "status", length = 30)
   private Status orderStatus;

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   private List<OrderItem> item = Lists.newArrayList();

   public User getUser()
   {
      return user;
   }

   public void setUser(User user)
   {
      this.user = user;
   }

   public String getOrderNumber()
   {
      return orderNumber;
   }

   public void setOrderNumber(String orderNumber)
   {
      this.orderNumber = orderNumber;
   }

   public Date getOrderDate()
   {
      return orderDate;
   }

   public void setOrderDate(Date orderDate)
   {
      this.orderDate = orderDate;
   }

   public Address getBillingAddress()
   {
      return billingAddress;
   }

   public void setBillingAddress(Address billingAddress)
   {
      this.billingAddress = billingAddress;
   }

   public Address getShippingAddress()
   {
      return shippingAddress;
   }

   public void setShippingAddress(Address shippingAddress)
   {
      this.shippingAddress = shippingAddress;
   }

   public Status getOrderStatus()
   {
      return orderStatus;
   }

   public void setOrderStatus(Status orderStatus)
   {
      this.orderStatus = orderStatus;
   }

   public List<OrderItem> getItem()
   {
      return item;
   }

   public void setItem(List<OrderItem> item)
   {
      this.item.clear();
      this.item.addAll(item);
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!super.equals(obj))
      {
         return false;
      }
      if (getClass() != obj.getClass())
      {
         return false;
      }
      Order other = (Order) obj;
      if (orderNumber == null)
      {
         if (other.orderNumber != null)
         {
            return false;
         }
      }
      else if (!orderNumber.equals(other.orderNumber))
      {
         return false;
      }
      return true;
   }

}
