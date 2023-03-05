package com.codestates.practice.order.mapper;

import com.codestates.practice.order.dto.OrderPatchDto;
import com.codestates.practice.order.dto.OrderPostDto;
import com.codestates.practice.order.dto.OrderResponseDto;
import com.codestates.practice.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order orderPostDtoToOrder(OrderPostDto orderPostDto);
    Order orderPatchDtoToOrder(OrderPatchDto orderPatchDto);
    OrderResponseDto orderToOrderResponseDto(Order order);
}
