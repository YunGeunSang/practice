package com.codestates.practice.order.controller;

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

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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

    public OrderController(OrderService orderService, OrderMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postOrder(@RequestBody @Valid OrderPostDto orderPostDto){
        Order order = mapper.orderPostDtoToOrder(orderPostDto);

        Order response = orderService.createOrder(order);

        return new ResponseEntity<>(mapper.orderToOrderResponseDto(response), HttpStatus.CREATED);
    }


    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId,
                                     @RequestBody @Valid OrderPatchDto orderPatchDto){
        orderPatchDto.setOrderId(orderId);

        Order order = mapper.orderPatchDtoToOrder(orderPatchDto);

        Order response = orderService.updateOrder(order);

        return new ResponseEntity<>(mapper.orderToOrderResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId){
        Order response = orderService.findOrder(orderId);

        return new ResponseEntity<>(mapper.orderToOrderResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders(){
        List<Order> orders = orderService.findOrders();

        List<OrderResponseDto> response = orders.stream()
                .map(order -> mapper.orderToOrderResponseDto(order))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId){
        orderService.deleteOrder(orderId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

