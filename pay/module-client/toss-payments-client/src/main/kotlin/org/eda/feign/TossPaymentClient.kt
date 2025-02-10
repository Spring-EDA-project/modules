package org.eda.feign

import org.eda.config.TossPaymentConfig
import org.eda.dto.req.PaymentConfirmRequest
import org.eda.dto.res.PaymentConfirmResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "toss-payments-feign",
    url = "#{@tossPaymentProperties.getBaseUrl()}",
    configuration = [TossPaymentConfig::class]
)
interface TossPaymentClient {
    @PostMapping("/v1/payments/confirm")
    fun paymentConfirm(@RequestBody paymentConfirmRequest: PaymentConfirmRequest): PaymentConfirmResponse

}