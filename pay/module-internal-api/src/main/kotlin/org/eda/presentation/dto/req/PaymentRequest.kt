package org.eda.presentation.dto.req

import org.eda.domain.Payment

data class PaymentRequest(
    val amount: Int,
    val paymentYn: Boolean,
    val orderProductId: Long
) {
    fun toPayment(): Payment {
        return Payment(
            amount = this.amount,
            paymentYn = this.paymentYn,
            orderProductId = this.orderProductId
        );
    }
}
