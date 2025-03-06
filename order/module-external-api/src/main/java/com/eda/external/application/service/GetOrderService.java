package com.eda.external.application.service;

import com.eda.domain.Order;
import com.eda.domain.OrderReader;
import com.eda.domain.OrderValidator;
import com.eda.external.application.port.in.GetOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderService implements GetOrderUseCase {
    private final OrderReader orderReader;
    private final OrderValidator orderValidator;

    public Order getOrder(Long memberId, Long orderId) {
        Order order = orderReader.read(orderId);
        orderValidator.validate(order, memberId);
        return order;
    }
}
