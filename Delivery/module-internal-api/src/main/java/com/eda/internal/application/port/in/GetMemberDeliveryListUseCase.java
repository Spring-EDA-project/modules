package com.eda.internal.application.port.in;

import com.eda.domain.Delivery;
import java.util.List;

public interface GetMemberDeliveryListUseCase {
    List<Delivery> getAllDelivery(Long memberId);
}
