package com.eda.domain;

import com.eda.rdbms.repository.ports.in.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderReader {
    private final OrderRepository orderRepository;

    public Long getMaxOrderId(Long time) {
        return orderRepository.findMaxId(time);
    }
}
