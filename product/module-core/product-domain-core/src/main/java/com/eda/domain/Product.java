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
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .image(this.image)
                .build();
    }

    public static Product fromEntity(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .image(productEntity.getImage())
                .build();
    }
}
