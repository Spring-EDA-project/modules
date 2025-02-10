package org.eda.config

import feign.RequestInterceptor
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@EnableConfigurationProperties(TossPaymentProperties::class)
@Configuration
class TossPaymentConfig(
    private val tossPaymentProperties: TossPaymentProperties,
) {
    companion object {
        private val HEADER_NAME = "Authorization"
        private val AUTHENTICATION_TYPE = "Basic "
    }

    @Bean
    fun requestInterceptor(): RequestInterceptor {
        val encodedCredentials = Base64.getEncoder().encodeToString("${tossPaymentProperties.secretKey}:".toByteArray())
        return RequestInterceptor { template ->
            template.header(HEADER_NAME, "$AUTHENTICATION_TYPE $encodedCredentials")
        }
    }
}