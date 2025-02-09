package org.eda.domain

import lombok.Getter

@Getter
class Payment(
    val id: Long? = null,
    var amount: Int,
    var paymentYn: Boolean,
    val orderProductId: Long
) {
}