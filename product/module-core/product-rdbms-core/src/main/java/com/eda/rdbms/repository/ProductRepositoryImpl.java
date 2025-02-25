package com.eda.rdbms.repository;

import com.eda.rdbms.entity.ProductEntity;
import com.eda.rdbms.repository.ports.in.ProductRepository;
import com.eda.rdbms.repository.ports.out.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    public ProductEntity save(ProductEntity productEntity) {
        return productJpaRepository.save(productEntity);
    }

    public ProductEntity findById(Long id) {
        // 추후 예외 생성으로 코드 변경 필요
        return productJpaRepository.findById(id).orElse(null);
    }

    public List<ProductEntity> findAll() {
        return productJpaRepository.findAll();
    }
}
