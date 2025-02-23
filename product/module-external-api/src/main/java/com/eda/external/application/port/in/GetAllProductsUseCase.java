package com.eda.external.application.port.in;

import com.eda.domain.Product;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Product> getAllProducts();
}
