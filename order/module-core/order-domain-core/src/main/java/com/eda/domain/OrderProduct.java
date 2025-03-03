package com.eda.domain;

import com.eda.rdbms.entity.OrderProductEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderProduct {
    private Long id;
    private Long orderId;
    private Long productId;
    private int amount;

    public OrderProductEntity toEntity() {
        return OrderProductEntity.builder()
                .orderId(orderId)
                .productId(productId)
                .amount(amount)
                .build();
    }

    public static OrderProduct fromEntity(OrderProductEntity entity) {
        return OrderProduct.builder()
                .id(entity.getId())
                .orderId(entity.getOrderId())
                .productId(entity.getProductId())
                .amount(entity.getAmount())
                .build();
    }
}
