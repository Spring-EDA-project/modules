package com.eda.external.application;

import com.eda.domain.Product;
import com.eda.external.application.port.in.GetAllProductsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsService implements GetAllProductsUseCase {
    public List<Product> getAllProducts() {
        return null;
    }
}
