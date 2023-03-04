package com.codestates.practice.coffee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/coffees")
public class CoffeeController {

    @PostMapping
    public String postCoffee(@RequestParam("korName") String korName,
                             @RequestParam("engName") String engName,
                             @RequestParam("price") int price){
        String response =
                "{\"" +
                        "korName\":\""+korName+"\"," +
                        "\"engName\":\""+engName+"\",\"" +
                        "price\":\"" + price+
                        "\"}";

        return response;
    }

    @GetMapping("/{member-id}")
    public String getCoffee(@PathVariable("member-id") long memberId){
        return null;
    }

    @GetMapping
    public String getCoffees(){
        return null;
    }
}
