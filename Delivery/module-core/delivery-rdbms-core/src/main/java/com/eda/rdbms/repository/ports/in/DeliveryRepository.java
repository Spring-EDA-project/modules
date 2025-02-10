package com.eda.rdbms.repository.ports.in;

import com.eda.rdbms.entity.DeliveryEntity;

public interface DeliveryRepository {
    DeliveryEntity save(DeliveryEntity deliveryEntity);
}

