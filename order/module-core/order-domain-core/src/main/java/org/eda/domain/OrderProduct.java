package org.eda.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderProduct {
    private Long id;
    private Long orderId;
    private Long productId;
    private int amount;
}
