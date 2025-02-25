package com.eda.domain;

import com.eda.rdbms.entity.ProductEntity;
import com.eda.rdbms.repository.ports.in.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductReader {
    private final ProductRepository productRepository;

    public Product getProduct(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId);
        return Product.fromEntity(productEntity);
    }

    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(Product::fromEntity).collect(Collectors.toList());
    }
}
