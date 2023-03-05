package com.codestates.practice.coffee.controller;

import com.codestates.practice.coffee.dto.CoffeePatchDto;
import com.codestates.practice.coffee.dto.CoffeePostDto;
import com.codestates.practice.coffee.entity.Coffee;
import com.codestates.practice.coffee.service.CoffeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto){
        Coffee coffee = new Coffee();
        coffee.setKorName(coffeePostDto.getKorName());
        coffee.setEngName(coffeePostDto.getEngName());
        coffee.setPrice(coffeePostDto.getPrice());

        Coffee response = coffeeService.createCoffee(coffee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);

        Coffee coffee = new Coffee();
        coffee.setCoffeeId(coffeePatchDto.getCoffeeId());
        coffee.setPrice(coffeePatchDto.getPrice());

        Coffee response = coffeeService.updateCoffee(coffee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        Coffee response = coffeeService.findCoffee(coffeeId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        List<Coffee> response = coffeeService.findCoffees();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id")long coffeeId){
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
