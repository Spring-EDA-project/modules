package org.eda.repository

import jakarta.transaction.Transactional
import org.eda.entity.PaymentEntity
import org.eda.repository.ports.`in`.PaymentRepository
import org.eda.repository.ports.out.PaymentJpaRepository
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryImpl(
    private val paymentJpaRepository: PaymentJpaRepository
) : PaymentRepository {

    @Transactional
    override fun save(paymentEntity: PaymentEntity): PaymentEntity {
        return paymentJpaRepository.save(paymentEntity)
    }
}