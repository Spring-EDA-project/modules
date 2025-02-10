package org.eda.external.application.port.in;

import org.eda.domain.Order;

public interface GetOrderUseCase {
    Order getOrder(Long userId, Long orderId);
}
