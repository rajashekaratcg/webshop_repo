package com.petsupplies.service.order;

import com.petsupplies.model.order.Order;

/**
 * Orders related services.
 *
 * @author rajassub (c) Jun 29, 2015, Sogeti B.V.
 */ 
public interface IOrderService
{
   void placeOrder(Order order);
}
