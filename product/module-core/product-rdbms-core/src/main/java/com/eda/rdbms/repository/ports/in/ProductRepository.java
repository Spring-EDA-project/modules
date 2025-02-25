package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity save(ProductEntity productEntity);
    ProductEntity findById(Long id);
    List<ProductEntity> findAll();
}
