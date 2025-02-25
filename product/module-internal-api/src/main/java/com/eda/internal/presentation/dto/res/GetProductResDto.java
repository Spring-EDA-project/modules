package com.eda.internal.presentation.dto.res;

import com.eda.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record GetProductResDto(
        Long id,
        String name,
        int price,
        String image
) {
    public static GetProductResDto of(Product product) {
        return GetProductResDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .build();
    }
}
