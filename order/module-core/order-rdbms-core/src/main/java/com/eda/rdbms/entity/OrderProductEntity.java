package com.eda.rdbms.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "tb_order_product")
@Builder
@Entity
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "amount")
    private int amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order", nullable = false)
    private OrderEntity order;
}
