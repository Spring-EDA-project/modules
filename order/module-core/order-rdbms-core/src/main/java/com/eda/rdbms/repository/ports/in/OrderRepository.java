package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.OrderEntity;

import java.util.List;

public interface OrderRepository {

    OrderEntity save(OrderEntity orderEntity);
    Long findMaxId(Long time);
    OrderEntity findById(Long id);
    List<OrderEntity> findByMemberId(Long memberId);
}
