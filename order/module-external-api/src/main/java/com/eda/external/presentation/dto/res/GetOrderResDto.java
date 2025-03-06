package com.eda.external.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import com.eda.domain.Order;
import com.eda.domain.OrderProduct;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record GetOrderResDto(
        Long orderId,
        List<OrderProduct> orderProducts
) {
    public static GetOrderResDto of(Order order) {
        return GetOrderResDto.builder()
                .orderId(order.getId())
                .orderProducts(order.getOrderProducts())
                .build();
    }
}
