package com.eda.domain;

import com.eda.rdbms.entity.OrderEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class Order {
    @Setter
    private Long id;
    private Long memberId;
    private List<OrderProduct> orderProducts;

    public OrderEntity toOrderEntity() {
        return OrderEntity.builder()
                .id(id)
                .memberId(memberId)
                .orderProducts(orderProducts.stream().map(OrderProduct::toEntity).toList())
                .build();
    }

    public static Order fromOrderEntity(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .memberId(orderEntity.getMemberId())
                .orderProducts(orderEntity.getOrderProducts().stream().map(OrderProduct::fromEntity).toList())
                .build();
    }
}
