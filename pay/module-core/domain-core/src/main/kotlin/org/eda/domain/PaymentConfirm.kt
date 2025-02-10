package org.eda.domain

class PaymentConfirm (
    val paymentKey: String,
    val orderId: String,
    val totalAmount: String,
    val status: String? = null
) {
}