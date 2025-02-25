package com.eda.external.application;

import com.eda.domain.Product;
import com.eda.domain.ProductReader;
import com.eda.external.application.port.in.GetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {
    private final ProductReader productReader;

    public Product getProduct(Long productId) {
        return productReader.getProduct(productId);
    }
}
