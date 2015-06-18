package com.petsupplies.model.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;
import com.petsupplies.model.product.Product;

@Entity
@Table(name = "CATEGORIES")
public class Category {
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @NotBlank
   @Column(length=100)
   private String name;

   @ManyToOne(optional=true)
   @JoinColumn(name="parent_id")
   private Category parent;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
   private List<Category> categories = Lists.newArrayList();
   
   @OneToMany(mappedBy = "category")
   private List<Product> products = Lists.newArrayList();

   protected Category() {
      
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

   public Category getParent() {
      return parent;
   }

   public void setParent(Category parent) {
      this.parent = parent;
   }

   public List<Category> getCategories() {
      return categories;
   }

   public void setCategories(List<Category> categories) {
      this.categories.clear();      
      this.categories.addAll(categories);
   }     

   public List<Product> getProducts() {
      return products;
   }

   public void setProducts(List<Product> products) {
      this.products = products;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
      Category other = (Category) obj;
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      if (parent == null) {
         if (other.parent != null) {
            return false;
         }
      } else if (!parent.equals(other.parent)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      final int maxLen = 2;
      StringBuilder builder = new StringBuilder();
      builder.append("Category [id=");
      builder.append(id);
      builder.append(", name=");
      builder.append(name);
      builder.append(", parent=");
      builder.append(parent);
      builder.append(", categories=");
      builder.append(categories != null ? categories.subList(0, Math.min(categories.size(), maxLen)) : null);
      builder.append("]");
      return builder.toString();
   }

}
