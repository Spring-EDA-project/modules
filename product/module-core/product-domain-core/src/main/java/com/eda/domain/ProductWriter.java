package com.eda.domain;

import com.eda.rdbms.entity.ProductEntity;
import com.eda.rdbms.repository.ports.in.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductWriter {
    private final ProductRepository productRepository;

    public Product write(Product product) {
        ProductEntity productEntity = product.toEntity();
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        return Product.fromEntity(savedProductEntity);
    }
}
