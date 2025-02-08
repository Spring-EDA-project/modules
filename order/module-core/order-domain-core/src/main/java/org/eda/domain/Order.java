package org.eda.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {
    private Long id;
    private String uuid;
    private Long memberId;
}
