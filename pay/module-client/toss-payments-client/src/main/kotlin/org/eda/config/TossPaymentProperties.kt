package org.eda.config

import lombok.Getter
import org.springframework.boot.context.properties.ConfigurationProperties

@Getter
@ConfigurationProperties(prefix = "payment.toss")
data class TossPaymentProperties(
    val secretKey: String,
    val url: String,
)
