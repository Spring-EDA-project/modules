package com.eda.external.presentation.dto.res;

import com.eda.domain.Delivery;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record DeliveryUpdateResDto(
    Long delivery_id,
    String destination,
    String invoiceNumber,
    Long memberId,
    Long orderProductId
) {
    public static DeliveryUpdateResDto of(Delivery delivery) {
        return DeliveryUpdateResDto.builder()
                .delivery_id(delivery.getId())
                .destination(delivery.getDestination())
                .invoiceNumber(delivery.getInvoiceNumber())
                .memberId(delivery.getMemberId())
                .orderProductId(delivery.getOrderProductId())
                .build();
    }
}
