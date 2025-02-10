package org.eda

import org.eda.domain.PaymentConfirm
import org.eda.dto.req.PaymentConfirmRequest
import org.eda.feign.TossPaymentClient
import org.springframework.stereotype.Service

@Service
class TossPaymentClientService(
    private val tossPaymentClient: TossPaymentClient
) {
    fun confirmPayment(paymentConfirm: PaymentConfirm): PaymentConfirm {
        val paymentConfirmRequest = PaymentConfirmRequest.of(paymentConfirm)
        val paymentConfirmResponse = tossPaymentClient.paymentConfirm(paymentConfirmRequest)
        return paymentConfirmResponse.toPaymentConfirm()
    }
}