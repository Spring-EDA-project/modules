package com.eda.external.application;

import com.eda.domain.Product;
import com.eda.domain.ProductReader;
import com.eda.external.application.port.in.GetAllProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProductsService implements GetAllProductsUseCase {
    private final ProductReader productReader;

    public List<Product> getAllProducts() {
        return productReader.getAllProducts();
    }
}
