package com.eda.domain;

import com.eda.rdbms.repository.ports.in.DeliveryRepository;

public class DeliveryReader {
    private final DeliveryRepository deliveryRepository;

    public DeliveryReader(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery getDelivery(Long id) {
        return DeliveryMapper.toDomain(deliveryRepository.getDelivery(id));
    }
}
