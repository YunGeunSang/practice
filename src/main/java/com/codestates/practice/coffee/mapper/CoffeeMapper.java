package com.codestates.practice.coffee.mapper;

import com.codestates.practice.coffee.dto.CoffeePatchDto;
import com.codestates.practice.coffee.dto.CoffeePostDto;
import com.codestates.practice.coffee.dto.CoffeeResponseDto;
import com.codestates.practice.coffee.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
}
