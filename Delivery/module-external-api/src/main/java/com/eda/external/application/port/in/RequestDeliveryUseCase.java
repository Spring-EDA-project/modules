package com.eda.external.application.port.in;

import com.eda.domain.Delivery;

public interface RequestDeliveryUseCase {
    Delivery requestDelivery(Delivery delivery);
}
