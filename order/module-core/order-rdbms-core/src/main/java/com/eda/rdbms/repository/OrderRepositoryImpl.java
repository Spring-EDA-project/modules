package com.eda.rdbms.repository;

import com.eda.rdbms.entity.OrderEntity;
import com.eda.rdbms.repository.ports.in.OrderRepository;
import com.eda.rdbms.repository.ports.out.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository jpaRepository;

    public OrderEntity save(OrderEntity orderEntity) {
        return jpaRepository.save(orderEntity);
    }

    public Long findMaxId(Long time) {
        return jpaRepository.findMaxOrderIdInRange(time * 1000, (time + 1) * 1000)
                .orElse(time * 1000);
    }

    public OrderEntity findById(Long id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderEntity> findByMemberId(Long memberId) {
        return jpaRepository.findByMemberId(memberId);
    }
}
