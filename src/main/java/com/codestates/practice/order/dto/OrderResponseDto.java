package com.codestates.practice.order.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private long coffeeId;
}
