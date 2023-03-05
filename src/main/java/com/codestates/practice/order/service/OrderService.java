package com.codestates.practice.order.service;

import com.codestates.practice.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public Order createOrder(Order order){
        Order createdOrder = order;

        return createdOrder;
    }

    public Order updateOrder(Order order){
        Order updatedOrder = order;

        return updatedOrder;
    }

    public Order findOrder(long orderId){
        Order order = new Order(1L, 1L, 1L);

        return order;
    }

    public List<Order> findOrders(){
        List<Order> orders = List.of(
                new Order(1L, 1L, 1L),
                new Order(2L, 1L, 2L)
        );

        return orders;
    }

    public void deleteOrder(long orderId){

    }
}
