package com.eda.external.application.service;

import com.eda.domain.Delivery;
import com.eda.domain.DeliveryReader;
import com.eda.external.application.port.in.GetDeliveryUseCase;
import com.eda.rdbms.repository.ports.in.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDeliveryService implements GetDeliveryUseCase {
    private final DeliveryReader deliveryReader;
    @Override
    public Delivery getDelivery(Long id) {
        return deliveryReader.getDelivery(id);
    }
}
