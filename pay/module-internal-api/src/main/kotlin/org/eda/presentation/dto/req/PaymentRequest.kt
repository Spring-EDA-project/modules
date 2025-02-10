package org.eda.presentation.dto.req

import org.eda.domain.Payment
import org.eda.domain.PaymentConfirm

data class PaymentRequest(
    val amount: Int,
    val paymentYn: Boolean,
    val orderProductId: Long,
    val paymentKey: String,
    val orderId: String,
) {
    fun toPayment(): Payment {
        return Payment(
            amount = this.amount,
            paymentYn = this.paymentYn,
            orderProductId = this.orderProductId
        );
    }

    fun toPaymentConfirm(): PaymentConfirm {
        return PaymentConfirm(
            paymentKey = this.paymentKey,
            orderId = this.orderId,
            totalAmount = this.amount.toString()
        )
    }
}
