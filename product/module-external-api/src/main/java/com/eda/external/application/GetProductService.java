package com.eda.external.application;

import com.eda.domain.Product;
import com.eda.external.application.port.in.GetProductUseCase;
import org.springframework.stereotype.Service;

@Service
public class GetProductService implements GetProductUseCase {
    public Product getProduct(Long productId) {
        return Product.builder()
                .id(productId)
                .image(null)
                .name(null)
                .price(0)
                .build();
    }
}
