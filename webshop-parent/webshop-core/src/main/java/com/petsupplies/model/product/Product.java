package com.petsupplies.model.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.petsupplies.model.AbstractModel;
import com.petsupplies.model.category.Category;

@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractModel
{

   private static final long serialVersionUID = -7323004865177581551L;

   @NotBlank
   @Column(length = 100)
   private String name;

   @Column(length = 1000)
   private String description;

   @Digits(integer = 7, fraction = 2)
   @Min(value = 0)
   private BigDecimal price;

   @ManyToOne(optional = false)
   @JoinColumn(name = "category_id")
   private Category category;

   public Product()
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

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public BigDecimal getPrice()
   {
      return price;
   }

   public void setPrice(BigDecimal price)
   {
      this.price = price;
   }

   public Category getCategory()
   {
      return category;
   }

   public void setCategory(Category category)
   {
      this.category = category;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((category == null) ? 0 : category.hashCode());
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
      Product other = (Product) obj;
      if (category == null)
      {
         if (other.category != null)
         {
            return false;
         }
      }
      else if (!category.equals(other.category))
      {
         return false;
      }
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
      builder.append("Product [id=");
      builder.append(this.getId());
      builder.append(", name=");
      builder.append(this.name);
      builder.append(", description=");
      builder.append(this.description);
      builder.append(", price=");
      builder.append(this.price);
      builder.append(", category=");
      builder.append(this.category);
      builder.append("]");
      return builder.toString();
   }

}
