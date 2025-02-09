package org.eda.service

import org.eda.domain.Payment
import org.eda.entity.PaymentEntity

class PaymentMapper {

    fun toDomain(paymentEntity: PaymentEntity): Payment {
        return Payment(
            amount = paymentEntity.amount,
            paymentYn = paymentEntity.paymentYn,
            orderProductId = paymentEntity.orderProductId
        )
    }

    fun toEntity(payment: Payment): PaymentEntity {
        return PaymentEntity(
            id = payment.id,
            amount = payment.amount,
            paymentYn = payment.paymentYn,
            orderProductId = payment.orderProductId
        )
    }
}