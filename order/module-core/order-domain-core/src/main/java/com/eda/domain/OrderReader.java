package com.eda.domain;

import com.eda.rdbms.entity.OrderEntity;
import com.eda.rdbms.repository.ports.in.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderReader {
    private final OrderRepository orderRepository;

    public Long getMaxOrderId(Long time) {
        return orderRepository.findMaxId(time);
    }

    public Order read(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId);
        return Order.fromOrderEntity(orderEntity);
    }

    public List<Order> readAll(Long memberId) {
        List<OrderEntity> orderEntities = orderRepository.findByMemberId(memberId);
        return orderEntities.stream().map(Order::fromOrderEntity).collect(Collectors.toList());
    }
}
