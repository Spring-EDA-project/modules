package com.eda.external.presentation.dto.req;

import com.eda.domain.Delivery;

public record DeliveryUpdateReqDto(String destination,
                                   Long memberId,
                                   Long orderProductId) {
    public Delivery toDelivery() {
        return Delivery.builder()
                .destination(this.destination)
                .memberId(this.memberId)
                .orderProductId(this.orderProductId)
                .build();
    }
}
