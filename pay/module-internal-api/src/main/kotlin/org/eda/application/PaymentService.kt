package org.eda.application

import org.eda.application.ports.`in`.PaymentUseCase
import org.eda.domain.Payment
import org.eda.service.PaymentWriter
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val paymentWriter: PaymentWriter
): PaymentUseCase {

    override fun pay(payment: Payment): Payment {
        return paymentWriter.store(payment);
    }
}