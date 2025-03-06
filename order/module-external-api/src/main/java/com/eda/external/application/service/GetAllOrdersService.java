package com.eda.external.application.service;

import com.eda.domain.Order;
import com.eda.domain.OrderReader;
import com.eda.external.application.port.in.GetAllOrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllOrdersService implements GetAllOrdersUseCase {
    private final OrderReader orderReader;

    public List<Order> getAllOrders(Long memberId) {
        return orderReader.readAll(memberId);
    }
}
