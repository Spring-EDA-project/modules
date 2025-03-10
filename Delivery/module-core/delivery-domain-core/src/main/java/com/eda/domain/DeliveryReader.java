package com.eda.domain;

import com.eda.rdbms.repository.ports.in.DeliveryRepository;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryReader {
    private final DeliveryRepository deliveryRepository;

    public DeliveryReader(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    public Delivery getDelivery(Long id) {
        return DeliveryMapper.toDomain(deliveryRepository.getDelivery(id));
    }
    public List<Delivery> getAllDeliveryByMember(Long memberId) {
        return deliveryRepository.getAllDeliveryByMember(memberId).stream()
            .map(DeliveryMapper::toDomain)
            .collect(Collectors.toList());
    }
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.getAllDelivery().stream()
            .map(DeliveryMapper::toDomain)
            .collect(Collectors.toList());
    }
}
