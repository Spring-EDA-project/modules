package com.eda.external.presentation.dto.res;

import com.eda.domain.Delivery;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record DeliveryResDto(
    Long delivery_id,
    String destination,
    String invoiceNumber,
    Long memberId,
    Long orderProductId
) {
    public static DeliveryResDto of(Delivery delivery) {
        return DeliveryResDto.builder()
            .delivery_id(delivery.getId())
            .destination(delivery.getDestination())
            .invoiceNumber(delivery.getInvoiceNumber())
            .memberId(delivery.getMemberId())
            .orderProductId(delivery.getOrderProductId())
            .build();
    }
}
