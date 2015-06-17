package com.petsupplies.model.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.petsupplies.model.category.Category;


@Entity
@Table(name="PRODUCTS")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(length = 100)
   private String name;

   @Column(length = 1000)
   private String description;

   private BigDecimal price;

   @ManyToOne(optional = false)
   @JoinColumn(name = "category_id")
   private Category category;

   protected Product() {

   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((category == null) ? 0 : category.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      Product other = (Product) obj;
      if (category == null) {
         if (other.category != null) {
            return false;
         }
      } else if (!category.equals(other.category)) {
         return false;
      }
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Product [id=");
      builder.append(id);
      builder.append(", name=");
      builder.append(name);
      builder.append(", description=");
      builder.append(description);
      builder.append(", price=");
      builder.append(price);
      builder.append(", category=");
      builder.append(category);
      builder.append("]");
      return builder.toString();
   }

}
