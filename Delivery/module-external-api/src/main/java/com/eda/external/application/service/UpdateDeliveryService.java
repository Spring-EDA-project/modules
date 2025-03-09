package com.eda.external.application.service;

import com.eda.domain.Delivery;
import com.eda.external.application.port.in.UpdateDeliveryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateDeliveryService implements UpdateDeliveryUseCase {

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        return null;
    }
}
