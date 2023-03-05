package com.codestates.practice.coffee.dto;

import org.hibernate.validator.constraints.Range;

public class CoffeePatchDto {
    private long coffeeId;

    @Range(min=100, max=50000)
    private int price;

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
