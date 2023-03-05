package com.codestates.practice.coffee.mapper;

import com.codestates.practice.coffee.dto.CoffeePatchDto;
import com.codestates.practice.coffee.dto.CoffeePostDto;
import com.codestates.practice.coffee.dto.CoffeeResponseDto;
import com.codestates.practice.coffee.entity.Coffee;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapper {
    public Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto){
        return new Coffee(0L, coffeePostDto.getKorName(), coffeePostDto.getEngName(), coffeePostDto.getPrice());
    }

    public Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto){
        return new Coffee(coffeePatchDto.getCoffeeId(),
                null,
                null,
                coffeePatchDto.getPrice());
    }

    public CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee){
        return new CoffeeResponseDto(coffee.getCoffeeId(),
                coffee.getKorName(),
                coffee.getEngName(),
                coffee.getPrice());
    }
}
