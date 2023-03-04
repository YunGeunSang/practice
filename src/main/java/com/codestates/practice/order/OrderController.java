package com.codestates.practice.order;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @PostMapping
    public String postOrder(@RequestParam("memberId") long memberId,
                            @RequestParam("coffeeId") long coffeeId){
        String response =
                "{\"" +
                        "memberId\":\""+memberId+"\"," +
                        "\"coffeeId\":\""+coffeeId+"\"" +
                        "}";
        return response;
    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") long orderId){
        return null;
    }

    @GetMapping
    public String getOrders(){
        return null;
    }
}
