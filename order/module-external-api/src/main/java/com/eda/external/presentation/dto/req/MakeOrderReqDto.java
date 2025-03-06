package com.eda.external.presentation.dto.req;

import com.eda.domain.OrderProduct;

import java.util.List;
import java.util.stream.Collectors;

public record MakeOrderReqDto(
        List<ProductItemDto> items
) {
    public record ProductItemDto(
            Long productId,
            int amount
    ) {}

    public List<OrderProduct> toOrderProducts() {
        return items.stream().map(item -> OrderProduct.builder()
                                .productId(item.productId())
                                .amount(item.amount())
                                .build()
                ).collect(Collectors.toList());
    }
}
