package com.eda.domain;

import com.eda.rdbms.entity.OrderEntity;
import com.eda.rdbms.repository.ports.in.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderWriter {
    private final OrderRepository orderRepository;

    public Order writeOrder(Order order) {
        OrderEntity orderEntity = order.toOrderEntity();
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return Order.fromOrderEntity(savedOrderEntity);
    }
}
