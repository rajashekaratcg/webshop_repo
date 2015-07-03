package com.petsupplies.web.model.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.petsupplies.model.product.Product;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable
{

   private static final long serialVersionUID = -714567164745942631L;

   private Map<Long, ShoppingCartItem> itemsMap = Maps.newHashMap();
   private double amount;

   public Collection<ShoppingCartItem> getItems()
   {
      return itemsMap.values();
   }

   public void addItem(Product product, int quantity)
   {
      if (product == null)
      {
         return;
      }

      if (itemsMap.containsKey(product.getId()))
      {
         ShoppingCartItem item = itemsMap.get(product.getId());
         item.setQuantity(quantity + item.getQuantity());
      }
      else
      {
         itemsMap.put(product.getId(), new ShoppingCartItem(product, quantity));
      }

      amount = amount + (product.getPrice().doubleValue() * (quantity));
   }

   public void removeItem(Long productId)
   {
      if (productId == null)
      {
         return;
      }

      itemsMap.remove(productId);
   }

   public double getAmount()
   {
      return amount;
   }

}
