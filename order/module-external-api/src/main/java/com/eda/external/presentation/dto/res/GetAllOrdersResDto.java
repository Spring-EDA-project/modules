package com.eda.external.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import com.eda.domain.Order;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record GetAllOrdersResDto(
        List<Order> orders
) {
    public static GetAllOrdersResDto of(List<Order> orders) {
        return GetAllOrdersResDto.builder()
                .orders(orders)
                .build();
    }
}
