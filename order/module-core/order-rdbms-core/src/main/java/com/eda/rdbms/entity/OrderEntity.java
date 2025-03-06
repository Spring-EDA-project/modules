package com.eda.rdbms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "tb_order")
@Builder
@Entity
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private Long id;
    @Column(name = "member_id")
    private Long memberId;
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    @Builder.Default
    private List<OrderProductEntity> orderProducts = new ArrayList<>();
}
