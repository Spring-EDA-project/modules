package org.eda.external.application;

import org.eda.domain.Order;
import org.eda.external.application.port.in.GetAllOrdersUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOrdersService implements GetAllOrdersUseCase {
    public List<Order> getAllOrders(Long userId) {
        return null;
    }
}
