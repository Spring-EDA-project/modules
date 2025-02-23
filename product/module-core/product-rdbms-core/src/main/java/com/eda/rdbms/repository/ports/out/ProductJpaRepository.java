package com.eda.rdbms.repository.ports.out;

import com.eda.rdbms.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
}
