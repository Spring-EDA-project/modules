package com.eda.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Delivery {
    private Long id;
    private String destination;
    private String invoiceNumber;
    private Long memberId;
    private Long orderProductId;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
