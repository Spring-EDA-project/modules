package org.eda.application

import org.eda.TossPaymentClientService
import org.eda.application.ports.`in`.PaymentUseCase
import org.eda.domain.Payment
import org.eda.domain.PaymentConfirm
import org.eda.service.PaymentWriter
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentWriter: PaymentWriter,
    private val tossPaymentClientService: TossPaymentClientService
) : PaymentUseCase {

    override fun confirmPayment(payment: Payment, paymentConfirm: PaymentConfirm): Payment {
        val payment = paymentWriter.write(payment)
        val paymentConfirm = tossPaymentClientService.confirmPayment(paymentConfirm)
        return payment
    }
}