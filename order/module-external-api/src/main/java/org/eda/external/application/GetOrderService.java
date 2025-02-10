package org.eda.external.application;

import org.eda.domain.Order;
import org.eda.external.application.port.in.GetOrderUseCase;
import org.springframework.stereotype.Service;

@Service
public class GetOrderService implements GetOrderUseCase {
    public Order getOrder(Long userId, Long orderId) {
        return null;
    }
}
