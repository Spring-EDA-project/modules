package com.eda.external.application.port.in;

import com.eda.domain.Delivery;

public interface GetDeliveryUseCase {
    Delivery getDelivery(Long id);

}
