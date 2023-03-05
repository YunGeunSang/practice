package com.codestates.practice.coffee.service;

import com.codestates.practice.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    public Coffee createCoffee(Coffee coffee){
        Coffee createdCoffee = coffee;

        return createdCoffee;
    }

    public Coffee updateCoffee(Coffee coffee){
        Coffee updatedCoffee = coffee;

        return updatedCoffee;
    }

    public Coffee findCoffee(long coffeeId){
        Coffee coffee = new Coffee(1L, "바닐라 라떼", "Vanila Latte", 4500);

        return coffee;
    }

    public List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(
                new Coffee(1L, "바닐라 라떼", "Vanila Latte", 4500),
                new Coffee(2L, "아메리카노", "americano", 3000)
        );

        return coffees;
    }

    public void deleteCoffee(long coffeeid){

    }
}
