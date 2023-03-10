package com.codestates.practice.order.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@Table("ORDER_COFFEE")
public class CoffeeRef {
    @Id
    private long orderCoffeeId;
    private long coffeeId; // 같은 애그리거트라 AggregateReference로 감싸지 않아도된다.
    private int quantity;
}
