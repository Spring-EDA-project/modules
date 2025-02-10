package org.eda.dto.req

import jakarta.validation.constraints.NotNull
import org.eda.domain.PaymentConfirm

data class PaymentConfirmRequest(
    @NotNull(message = "PaymentKey가 존재하지 않습니다.") val paymentKey: String,
    @NotNull(message = "OrderId가 존재하지 않습니다.") val orderId: String,
    @NotNull(message = "Amount가 존재하지 않습니다.") val amount: Long,
) {
    companion object {
        fun of(paymentConfirm: PaymentConfirm): PaymentConfirmRequest {
            return PaymentConfirmRequest(
                paymentKey = paymentConfirm.paymentKey,
                orderId = paymentConfirm.orderId,
                amount = paymentConfirm.totalAmount.toLong()
            )
        }
    }
}
