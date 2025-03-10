package com.eda.internal.application.service;

import com.eda.domain.Delivery;
import com.eda.domain.DeliveryReader;
import com.eda.internal.application.port.in.GetAllDeliveryUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllDeliveryService implements GetAllDeliveryUseCase {
    private final DeliveryReader deliveryReader;

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryReader.getAllDelivery();
    }
}
