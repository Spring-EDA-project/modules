package org.eda.presentation.dto.res

import org.eda.domain.Payment

data class PaymentResponse(
    val id: Long?,
    val amount: Int,
    val paymentYn: Boolean,
    val orderProductId: Long
) {
    companion object {
        fun of(payment: Payment): PaymentResponse {
            return PaymentResponse (
                id = payment.id,
                amount = payment.amount,
                paymentYn = payment.paymentYn,
                orderProductId = payment.orderProductId
            )
        }
    }
}
