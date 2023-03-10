package com.codestates.practice.order.repository;

import com.codestates.practice.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
