package com.eda.rdbms.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "tb_delivery")
@Builder
@Entity
public class DeliveryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    @Column(name = "destination")
    private String destination;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "oreder_product_id")
    private Long orderProductId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

}
