package com.eda.external.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import com.eda.domain.Product;

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
