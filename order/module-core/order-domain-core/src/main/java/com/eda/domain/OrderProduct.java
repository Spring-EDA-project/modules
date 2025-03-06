package com.eda.domain;

import com.eda.rdbms.entity.OrderProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class OrderProduct {
    private Long id;
    private Long productId;
    private int amount;
    @Setter
    private Long orderId;

    public OrderProductEntity toEntity() {
        return OrderProductEntity.builder()
                .productId(productId)
                .amount(amount)
                .orderId(orderId)
                .build();
    }

    public static OrderProduct fromEntity(OrderProductEntity entity) {
        return OrderProduct.builder()
                .id(entity.getId())
                .productId(entity.getProductId())
                .amount(entity.getAmount())
                .orderId(entity.getOrderId())
                .build();
    }
}
