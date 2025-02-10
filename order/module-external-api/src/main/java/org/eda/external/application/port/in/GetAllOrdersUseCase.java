package org.eda.external.application.port.in;

import org.eda.domain.Order;

import java.util.List;

public interface GetAllOrdersUseCase {
    List<Order> getAllOrders(Long userId);
}
