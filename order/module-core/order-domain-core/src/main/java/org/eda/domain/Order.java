package org.eda.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Order {
    private Long id;
    private String uuid;
    private Long memberId;
    private List<OrderProduct> orderProducts;
}
