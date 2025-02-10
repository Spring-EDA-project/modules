package org.eda.application.ports.`in`

import org.eda.domain.Payment
import org.eda.domain.PaymentConfirm

interface PaymentUseCase {
    fun confirmPayment(payment: Payment, paymentConfirm: PaymentConfirm): Payment
}