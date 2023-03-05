package com.codestates.practice.order.controller;

import com.codestates.practice.order.dto.OrderPatchDto;
import com.codestates.practice.order.dto.OrderPostDto;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity postOrder(@RequestBody @Valid OrderPostDto orderPostDto){


        return new ResponseEntity<>(orderPostDto, HttpStatus.CREATED);
    }


    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                     @RequestBody @Valid OrderPatchDto orderPatchDto){

        return new ResponseEntity<>(orderPatchDto, HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

