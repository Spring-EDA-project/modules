package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.DeliveryEntity;
import java.util.List;

public interface DeliveryRepository {
    DeliveryEntity save(DeliveryEntity deliveryEntity);
    DeliveryEntity getDelivery(Long id);
}

