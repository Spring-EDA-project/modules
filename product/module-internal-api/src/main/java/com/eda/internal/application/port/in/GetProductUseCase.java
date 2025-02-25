package com.eda.internal.application.port.in;

import com.eda.domain.Product;

public interface GetProductUseCase {
    Product getProduct(Long productId);
}
