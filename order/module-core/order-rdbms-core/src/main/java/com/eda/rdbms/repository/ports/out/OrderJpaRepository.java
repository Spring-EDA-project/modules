package com.eda.rdbms.repository.ports.out;

import com.eda.rdbms.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
