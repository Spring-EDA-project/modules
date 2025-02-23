package com.eda.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    Long id;
    String name;
    int price;
    String image;
}
