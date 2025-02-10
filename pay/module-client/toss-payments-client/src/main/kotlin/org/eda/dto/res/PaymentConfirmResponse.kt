package org.eda.dto.res

import org.eda.domain.Payment
import org.eda.domain.PaymentConfirm

data class PaymentConfirmResponse(
    val paymentKey: String,
    val orderId: String,
    val totalAmount: String,
    val status: String
) {
    fun toPaymentConfirm(): PaymentConfirm {
        return PaymentConfirm (
            paymentKey = this.paymentKey,
            orderId = this.orderId,
            totalAmount = this.totalAmount,
            status = this.status
        )
    }
}
