package com.eda.external.presentation.dto.req;

import java.util.List;

public record MakeOrderReqDto(
        Long memberId,
        List<ProductItemDto> items
) {
    public record ProductItemDto(
            Long productId,
            int amount
    ) {}
}
