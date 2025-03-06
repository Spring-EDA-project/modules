package com.eda.external.config;

import com.eda.domain.OrderReader;
import com.eda.domain.OrderValidator;
import com.eda.domain.OrderWriter;
import com.eda.rdbms.repository.OrderRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OrderConfig {
    public final OrderRepositoryImpl orderRepositoryImpl;

    @Bean
    public OrderWriter orderWriter() {
        return new OrderWriter(orderRepositoryImpl);
    }

    @Bean
    public OrderReader orderReader() {
        return new OrderReader(orderRepositoryImpl);
    }

    @Bean
    public OrderValidator orderValidator() {
        return new OrderValidator();
    }
}
