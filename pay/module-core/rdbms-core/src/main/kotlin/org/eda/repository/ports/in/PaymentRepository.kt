package org.eda.repository.ports.`in`

import org.eda.entity.PaymentEntity

interface PaymentRepository {
    fun save(paymentEntity: PaymentEntity): PaymentEntity
}