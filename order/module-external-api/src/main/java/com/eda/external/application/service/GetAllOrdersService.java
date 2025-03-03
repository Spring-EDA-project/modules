package com.eda.external.application.service;

import com.eda.domain.Order;
import com.eda.external.application.port.in.GetAllOrdersUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOrdersService implements GetAllOrdersUseCase {
    public List<Order> getAllOrders(Long userId) {
        return null;
    }
}
