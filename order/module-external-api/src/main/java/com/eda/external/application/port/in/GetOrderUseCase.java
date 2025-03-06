package com.eda.external.application.port.in;

import com.eda.domain.Order;

public interface GetOrderUseCase {
    Order getOrder(Long memberId, Long orderId);
}
