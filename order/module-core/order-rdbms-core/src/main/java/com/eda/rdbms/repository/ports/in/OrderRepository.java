package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.OrderEntity;

public interface OrderRepository {

    OrderEntity save(OrderEntity orderEntity);
    Long findMaxId(Long time);
    OrderEntity findById(Long id);
}
