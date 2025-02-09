package org.eda.service

import org.eda.domain.Payment
import org.eda.repository.ports.`in`.PaymentRepository

class PaymentWriter(
    private val paymentMapper: PaymentMapper,
    private val paymentRepository: PaymentRepository
) {
    fun write(payment: Payment): Payment {
        val paymentEntity = paymentMapper.toEntity(payment)
        val savedPaymentEntity = paymentRepository.save(paymentEntity)
        return paymentMapper.toDomain(savedPaymentEntity)
    }
}