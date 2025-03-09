package com.eda.external.presentation;

import com.eda.domain.Delivery;
import com.eda.external.application.port.in.GetAllDeliveryUseCase;
import com.eda.external.application.port.in.GetDeliveryUseCase;
import com.eda.external.application.port.in.UpdateDeliveryUseCase;
import com.eda.external.presentation.dto.req.DeliveryUpdateReqDto;
import com.eda.external.presentation.dto.res.DeliveryListResDto;
import com.eda.external.presentation.dto.res.DeliveryResDto;
import com.eda.external.presentation.dto.res.DeliveryUpdateResDto;
import com.eda.global.common.response.BaseResponse;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/delivery")
@RestController
public class DeliveryApiController {
    private final UpdateDeliveryUseCase updateDeliveryUseCase;
    private final GetDeliveryUseCase getDeliveryUseCase;
    private final GetAllDeliveryUseCase getAllDeliveryUseCase;

    @PatchMapping("/{deliveryId}")
    public ResponseEntity<BaseResponse<?>> updateDelivery(@PathVariable(name = "deliveryId") final Long deliveryId,  @RequestBody final DeliveryUpdateReqDto deliveryUpdateReqDto) {
//        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(deliveryUpdateUseCase.updateDelivery(deliveryUpdateReqDto.toDelivery()));
        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(deliveryUpdateReqDto.toDelivery());
        return BaseResponse.ok(resDto);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<BaseResponse<?>> getDelivery(@PathVariable(name = "deliveryId") final Long deliveryId) {
        final DeliveryResDto resDto = DeliveryResDto.of(getDeliveryUseCase.getDelivery(deliveryId));
        return BaseResponse.ok(resDto);
    }

    @GetMapping("/list/{memberId}")
    public ResponseEntity<BaseResponse<?>> getAllDeliveries(@PathVariable(name = "memberId") final Long memberId) {
        final DeliveryListResDto resDto = DeliveryListResDto.of(getAllDeliveryUseCase.getAllDelivery(memberId));
        return BaseResponse.ok(resDto);
    }

}
