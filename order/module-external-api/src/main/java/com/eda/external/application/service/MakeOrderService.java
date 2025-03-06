package com.eda.external.application.service;

import com.eda.domain.Order;
import com.eda.domain.OrderReader;
import com.eda.domain.OrderWriter;
import com.eda.external.application.port.in.MakeOrderUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class MakeOrderService implements MakeOrderUseCase {
    private final OrderWriter orderWriter;
    private final OrderReader orderReader;

    public void makeOrder(Order order) {
        Long time = Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        Long newId = orderReader.getMaxOrderId(time) + 1L;
        order.setId(newId);
        order.getOrderProducts().forEach(product -> {
            // 상품 검증
            product.setOrderId(newId);
        });
        orderWriter.writeOrder(order);
    }
}
