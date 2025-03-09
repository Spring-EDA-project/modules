package com.eda.rdbms.repository.ports.out;

import com.eda.rdbms.entity.DeliveryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {
    List<DeliveryEntity> findAllByMemberId(Long memberId);
}

