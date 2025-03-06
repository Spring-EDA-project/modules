package com.eda.external.application.port.in;

import com.eda.domain.OrderProduct;

import java.util.List;

public interface MakeOrderUseCase {
        void makeOrder(List<OrderProduct> orderProducts, Long memberId);
}
