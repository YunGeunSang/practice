package com.codestates.practice.order.controller;

import com.codestates.practice.order.dto.OrderPatchDto;
import com.codestates.practice.order.dto.OrderPostDto;
import com.codestates.practice.order.entity.Order;
import com.codestates.practice.order.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity postOrder(@RequestBody @Valid OrderPostDto orderPostDto){
        Order order = new Order();
        order.setCoffeeId(orderPostDto.getCoffeeId());
        order.setMemberId(orderPostDto.getMemberId());

        Order response = orderService.createOrder(order);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                     @RequestBody @Valid OrderPatchDto orderPatchDto){
        orderPatchDto.setOrderId(orderId);

        Order order = new Order();
        order.setOrderId(orderPatchDto.getOrderId());
        order.setCoffeeId(orderPatchDto.getCoffeeId());

        Order response = orderService.updateOrder(order);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId){
        Order response = orderService.findOrder(orderId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(){
        List<Order> response = orderService.findOrders();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId){
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

