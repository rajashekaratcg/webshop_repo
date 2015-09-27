package com.petsupplies.model.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.petsupplies.model.AbstractModel;
import com.petsupplies.model.product.Product;

@Entity
@Table(name = "CATEGORIES")
public class Category extends AbstractModel
{

   private static final long serialVersionUID = -7675917656100278578L;

   @NotBlank
   @Column(length = 100)
   private String name;

   @ManyToOne(optional = true)
   @JoinColumn(name = "parent_id")
   private Category parent;

   @JsonIgnore
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
   private List<Category> categories = Lists.newArrayList();

   @JsonIgnore
   @OneToMany(mappedBy = "category")
   private List<Product> products = Lists.newArrayList();

   public Category()
   {

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
      Category other = (Category) obj;
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
      if (parent == null)
      {
         if (other.parent != null)
         {
            return false;
         }
      }
      else if (!parent.equals(other.parent))
      {
         return false;
      }
      return true;
   }

   public List<Category> getCategories()
   {
      return categories;
   }

   public String getName()
   {
      return name;
   }

   public Category getParent()
   {
      return parent;
   }

   public List<Product> getProducts()
   {
      return products;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((parent == null) ? 0 : parent.hashCode());
      return result;
   }

   public void setCategories(List<Category> categories)
   {
      this.categories.clear();
      this.categories.addAll(categories);
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setParent(Category parent)
   {
      this.parent = parent;
   }

   public void setProducts(List<Product> products)
   {
      this.products = products;
   }

   @Override
   public String toString()
   {
      final int maxLen = 2;
      StringBuilder builder = new StringBuilder();
      builder.append("Category [id=");
      builder.append(this.getId());
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
