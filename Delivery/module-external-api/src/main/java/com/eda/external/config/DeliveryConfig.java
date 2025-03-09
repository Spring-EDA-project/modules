package com.eda.external.config;

import com.eda.domain.DeliveryMapper;
import com.eda.domain.DeliveryReader;
import com.eda.domain.DeliveryWriter;
import com.eda.rdbms.repository.DeliveryRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DeliveryConfig {
    private final DeliveryRepositoryImpl deliveryRepositoryImpl;

    @Bean
    public DeliveryMapper deliveryMapper() {
        return new DeliveryMapper();
    }

    @Bean
    public DeliveryWriter deliveryWriter() {
        DeliveryMapper deliveryMapper = new DeliveryMapper();
        return new DeliveryWriter(deliveryRepositoryImpl, deliveryMapper);
    }

    @Bean
    public DeliveryReader deliveryReader() {
        return new DeliveryReader(deliveryRepositoryImpl);
    }


}
