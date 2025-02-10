package com.eda.rdbms.repository;

import lombok.RequiredArgsConstructor;
import com.eda.rdbms.entity.DeliveryEntity;
import com.eda.rdbms.repository.ports.in.DeliveryRepository;
import com.eda.rdbms.repository.ports.out.DeliveryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements DeliveryRepository {
    private final DeliveryJpaRepository deliveryJpaRepository;

    public DeliveryEntity save(DeliveryEntity deliveryEntity) {
        return deliveryJpaRepository.save(deliveryEntity);
    }
}
