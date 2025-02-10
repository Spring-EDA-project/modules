package org.eda.presentation

import org.eda.application.ports.`in`.PaymentUseCase
import org.eda.presentation.dto.req.PaymentRequest
import org.eda.presentation.dto.res.PaymentResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1")
@RestController
class InternalApiController(
    private val paymentUseCase: PaymentUseCase
) {

    @PostMapping
    fun confirmPayment(@RequestBody paymentRequest: PaymentRequest): PaymentResponse {
        return PaymentResponse.of(paymentUseCase.confirmPayment(paymentRequest.toPayment()))
    }
}