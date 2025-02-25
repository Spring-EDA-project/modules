package com.eda.external.application.port.in;

import com.eda.domain.Order;

import java.util.List;

public interface GetAllOrdersUseCase {
    List<Order> getAllOrders(Long userId);
}
