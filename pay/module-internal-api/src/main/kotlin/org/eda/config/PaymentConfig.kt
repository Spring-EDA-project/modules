package org.eda.config

import org.eda.repository.PaymentRepositoryImpl
import org.eda.repository.ports.`in`.PaymentRepository
import org.eda.service.PaymentMapper
import org.eda.service.PaymentWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentConfig (
    private val paymentRepositoryImpl: PaymentRepositoryImpl
) {

    @Bean
    fun paymentRepository(): PaymentRepository {
        return paymentRepositoryImpl;
    }

    @Bean
    fun paymentMapper(): PaymentMapper {
        return paymentMapper()
    }

    @Bean
    fun paymentWriter(): PaymentWriter {
        return PaymentWriter(
            paymentMapper = this.paymentMapper(),
            paymentRepository = this.paymentRepository()
        )
    }
}