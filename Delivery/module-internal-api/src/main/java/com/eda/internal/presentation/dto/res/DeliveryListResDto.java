package com.eda.internal.presentation.dto.res;

import com.eda.domain.Delivery;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record DeliveryListResDto(
    List<DeliveryResDto> deliveryList
) {
    public static DeliveryListResDto of(List<Delivery> deliveryList) {
        return DeliveryListResDto.builder()
            .deliveryList(deliveryList.stream().map(DeliveryResDto::of).toList())
            .build();
    }
}
