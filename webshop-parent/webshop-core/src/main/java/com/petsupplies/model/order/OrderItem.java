package com.petsupplies.model.order;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import com.petsupplies.model.AbstractModel;
import com.petsupplies.model.product.Product;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem extends AbstractModel
{

   private static final long serialVersionUID = -8970818126437842220L;

   @ManyToOne(optional = false)
   @JoinColumn(name = "order_id")
   private Order order;

   @ManyToOne(optional = false)
   @JoinColumn(name = "product_id")
   private Product product;

   @Range(min = 1, max = 1000)
   private Integer quantity;

   @Digits(integer = 7, fraction = 2)
   @Min(value = 0)
   private BigDecimal amount;

   public Order getOrder()
   {
      return order;
   }

   public void setOrder(Order order)
   {
      this.order = order;
   }

   public Product getProduct()
   {
      return product;
   }

   public void setProduct(Product product)
   {
      this.product = product;
   }

   public Integer getQuantity()
   {
      return quantity;
   }

   public void setQuantity(Integer quantity)
   {
      this.quantity = quantity;
   }

   public BigDecimal getAmount()
   {
      return amount;
   }

   public void setAmount(BigDecimal amount)
   {
      this.amount = amount;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((amount == null) ? 0 : amount.hashCode());
      result = prime * result + ((order == null) ? 0 : order.hashCode());
      result = prime * result + ((product == null) ? 0 : product.hashCode());
      result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
      OrderItem other = (OrderItem) obj;
      if (amount == null)
      {
         if (other.amount != null)
         {
            return false;
         }
      }
      else if (!amount.equals(other.amount))
      {
         return false;
      }
      if (order == null)
      {
         if (other.order != null)
         {
            return false;
         }
      }
      else if (!order.equals(other.order))
      {
         return false;
      }
      if (product == null)
      {
         if (other.product != null)
         {
            return false;
         }
      }
      else if (!product.equals(other.product))
      {
         return false;
      }
      if (quantity == null)
      {
         if (other.quantity != null)
         {
            return false;
         }
      }
      else if (!quantity.equals(other.quantity))
      {
         return false;
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder builder = new StringBuilder();
      builder.append("OrderItem [order=").append(order).append(", product=").append(product).append(", quantity=").append(quantity).append(", amount=").append(amount).append("]");
      return builder.toString();
   }

}
