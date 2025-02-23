package com.eda.domain;

import com.eda.rdbms.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    Long id;
    String name;
    int price;
    String image;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .name(name)
                .price(price)
                .image(image)
                .build();
    }
}
