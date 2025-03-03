package com.eda.external.application.service;

import com.eda.domain.Order;
import com.eda.external.application.port.in.GetOrderUseCase;
import org.springframework.stereotype.Service;

@Service
public class GetOrderService implements GetOrderUseCase {
    public Order getOrder(Long userId, Long orderId) {
        return null;
    }
}
