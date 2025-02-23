package com.eda.rdbms.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "tb_product")
@Builder
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "image")
    private String image;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
}
