package com.eda.external.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import com.eda.domain.Product;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record GetAllProductsResDto(
        List<Product> products
) {
    public static GetAllProductsResDto of(List<Product> products) {
        return GetAllProductsResDto.builder()
                .products(products)
                .build();
    }
}
