package com.codestates.practice.order.dto;

import javax.validation.constraints.Positive;

public class OrderPatchDto {
    @Positive
    private long orderId;
    @Positive
    private long coffeeId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }
}
