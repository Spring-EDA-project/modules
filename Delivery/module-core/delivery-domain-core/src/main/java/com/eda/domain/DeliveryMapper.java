package com.eda.domain;

import com.eda.rdbms.entity.DeliveryEntity;

public class DeliveryMapper {

    public static DeliveryEntity toEntity(Delivery delivery) {
        return DeliveryEntity.builder()
            .id(delivery.getId())
            .destination(delivery.getDestination())
            .invoiceNumber(delivery.getInvoiceNumber())
            .memberId(delivery.getMemberId())
            .orderProductId(delivery.getOrderProductId())
            .createdAt(delivery.getCreatedAt())
            .lastModifiedAt(delivery.getLastModifiedAt())
            .build();
    }

    public static Delivery toDomain(DeliveryEntity entity) {
        return Delivery.builder()
            .id(entity.getId())
            .destination(entity.getDestination())
            .invoiceNumber(entity.getInvoiceNumber())
            .memberId(entity.getMemberId())
            .orderProductId(entity.getOrderProductId())
            .createdAt(entity.getCreatedAt())
            .lastModifiedAt(entity.getLastModifiedAt())
            .build();
    }
}
