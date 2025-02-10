package com.eda.domain;

import com.eda.rdbms.entity.DeliveryEntity;
import com.eda.rdbms.repository.ports.in.DeliveryRepository;

public class DeliveryWriter {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryWriter(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    public Delivery write(Delivery delivery) {
        DeliveryEntity deliveryEntity = deliveryMapper.toEntity(delivery);
        DeliveryEntity savedDeliveryEntity = deliveryRepository.save(deliveryEntity);
        return deliveryMapper.toDomain(savedDeliveryEntity);
    }
}