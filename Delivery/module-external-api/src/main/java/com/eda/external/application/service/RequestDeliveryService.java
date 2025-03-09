package com.eda.external.application.service;

import com.eda.domain.Delivery;
import com.eda.external.application.port.in.RequestDeliveryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RequestDeliveryService implements RequestDeliveryUseCase {

    @Override
    public Delivery requestDelivery(Delivery delivery) {
        return null;
    }
}
