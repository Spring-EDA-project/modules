package com.eda.rdbms.repository;

import com.eda.rdbms.entity.OrderEntity;
import com.eda.rdbms.repository.ports.in.OrderRepository;
import com.eda.rdbms.repository.ports.out.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository jpaRepository;

    public OrderEntity save(OrderEntity orderEntity) {
        return jpaRepository.save(orderEntity);
    }
}
