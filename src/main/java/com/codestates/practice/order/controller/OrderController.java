package com.codestates.practice.order.controller;

import com.codestates.practice.coffee.service.CoffeeService;
import com.codestates.practice.order.dto.OrderPatchDto;
import com.codestates.practice.order.dto.OrderPostDto;
import com.codestates.practice.order.dto.OrderResponseDto;
import com.codestates.practice.order.entity.Order;
import com.codestates.practice.order.mapper.OrderMapper;
import com.codestates.practice.order.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/orders")
@Validated
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper mapper;
    private final static String ORDER_DEFAULT_URL = "/v10/orders";
    private final CoffeeService coffeeService;

    public OrderController(OrderService orderService, OrderMapper mapper, CoffeeService coffeeService) {
        this.orderService = orderService;
        this.mapper = mapper;
        this.coffeeService = coffeeService;
    }

    @PostMapping
    public ResponseEntity postOrder(@RequestBody @Valid OrderPostDto orderPostDto){
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));

        // (2) 등록된 주문(Resource)에 해당하는 URI 객체
        URI location =
                UriComponentsBuilder
                        .newInstance()
                        .path(ORDER_DEFAULT_URL + "/{order-id}")
                        .buildAndExpand(order.getOrderId())
                        .toUri();               // "/v10/orders/{order-id}"

        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId){
        Order order = orderService.findOrder(orderId);

        // (4) 주문한 커피 정보를 가져오도록 수정
        return new ResponseEntity<>(
                mapper.orderToOrderResponseDto(coffeeService, order),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(){
        List<Order> orders = orderService.findOrders();

        // (5) 주문한 커피 정보를 가져오도록 수정
        List<OrderResponseDto> response =
                orders
                        .stream()
                        .map(order -> mapper.orderToOrderResponseDto(coffeeService, order))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId){
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

