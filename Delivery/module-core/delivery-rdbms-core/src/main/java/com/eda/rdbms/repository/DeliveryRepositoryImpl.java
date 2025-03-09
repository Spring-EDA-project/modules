package com.eda.rdbms.repository;

import com.eda.global.common.error.exception.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.eda.rdbms.entity.DeliveryEntity;
import com.eda.rdbms.repository.ports.in.DeliveryRepository;
import com.eda.rdbms.repository.ports.out.DeliveryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {
    private final DeliveryJpaRepository deliveryJpaRepository;

    public DeliveryEntity save(DeliveryEntity deliveryEntity) {
        return deliveryJpaRepository.save(deliveryEntity);
    }
    @Override
    public DeliveryEntity getDelivery(Long id) {
        return deliveryJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<DeliveryEntity> getAllDelivery(Long memberId) {
        return deliveryJpaRepository.findAllByMemberId(memberId);
    }
}
