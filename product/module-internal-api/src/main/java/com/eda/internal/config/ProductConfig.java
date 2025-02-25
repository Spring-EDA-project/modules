package com.eda.internal.config;

import com.eda.domain.ProductReader;
import com.eda.domain.ProductWriter;
import com.eda.rdbms.repository.ProductRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductConfig {

    public final ProductRepositoryImpl productRepositoryImpl;

    @Bean
    public ProductWriter productWriter() {
        return new ProductWriter(productRepositoryImpl);
    }

    @Bean
    public ProductReader productReader() {
        return new ProductReader(productRepositoryImpl);
    }
}
