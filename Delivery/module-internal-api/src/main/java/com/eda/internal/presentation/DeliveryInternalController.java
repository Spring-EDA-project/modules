package com.eda.internal.presentation;

import com.eda.global.common.response.BaseResponse;
import com.eda.internal.application.port.in.GetAllDeliveryUseCase;
import com.eda.internal.application.port.in.GetMemberDeliveryListUseCase;
import com.eda.internal.presentation.dto.res.DeliveryListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/delivery")
@RequiredArgsConstructor
public class DeliveryInternalController {
    private final GetAllDeliveryUseCase getAllDeliveryUseCase;
    private final GetMemberDeliveryListUseCase getMemberDeliveryListUseCase;

    @GetMapping("/")
    public ResponseEntity<BaseResponse<?>> getAllDeliveries() {
        DeliveryListResDto resDto = DeliveryListResDto.of(getAllDeliveryUseCase.getAllDelivery());
        return BaseResponse.ok(resDto);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<BaseResponse<?>> getAllMemberDeliveries(@PathVariable(name = "memberId") final Long memberId) {
        DeliveryListResDto resDto = DeliveryListResDto.of(getMemberDeliveryListUseCase.getAllDelivery(memberId));
        return BaseResponse.ok(resDto);
    }


}
