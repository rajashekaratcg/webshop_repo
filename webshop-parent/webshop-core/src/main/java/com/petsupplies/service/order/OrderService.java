package com.petsupplies.service.order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsupplies.model.order.Order;
import com.petsupplies.repository.order.OrderRepository;

@Service("orderService")
@Transactional
public class OrderService implements IOrderService
{
   @Autowired
   private OrderRepository orderRepository;
   
   @Override
   public void placeOrder(Order order)
   {
      orderRepository.save(order);      
   }

}
