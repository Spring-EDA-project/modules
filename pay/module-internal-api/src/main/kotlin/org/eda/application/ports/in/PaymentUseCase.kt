package org.eda.application.ports.`in`

import org.eda.domain.Payment

interface PaymentUseCase {
    fun pay(payment: Payment): Payment
}