package com.eda.external.presentation;

import com.eda.common.response.SuccessResponse;
import com.eda.domain.Delivery;
import com.eda.external.application.in.UpdateDeliveryUseCase;
import com.eda.external.application.in.RequestDeliveryUseCase;
import com.eda.external.presentation.dto.req.DeliveryUpdateReqDto;
import com.eda.external.presentation.dto.req.RequestDeliveryReqDto;
import com.eda.external.presentation.dto.res.DeliveryUpdateResDto;
import com.eda.external.presentation.dto.res.RequestDeliveryResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/delivery")
@RestController
public class DeliveryApiController {
    private final RequestDeliveryUseCase requestDeliveryUseCase;
    private final UpdateDeliveryUseCase updateDeliveryUseCase;

    @PostMapping("/")
    public ResponseEntity<SuccessResponse<?>> requestDelivery(@RequestBody final RequestDeliveryReqDto requestDeliveryReqDto) {
//        final RequestDeliveryResDto resDto = RequestDeliveryResDto.of(requestDeliveryUseCase.requestDelivery(requestDeliveryReqDto.toDelivery()));
        final RequestDeliveryResDto resDto = RequestDeliveryResDto.of(requestDeliveryReqDto.toDelivery());
        return SuccessResponse.ok(resDto);
    }

    @PatchMapping("/{deliveryId}")
    public ResponseEntity<SuccessResponse<?>> updateDelivery(@RequestParam(name = "deliveryId") final Long deliveryId,  @RequestBody final DeliveryUpdateReqDto deliveryUpdateReqDto) {
//        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(deliveryUpdateUseCase.updateDelivery(deliveryUpdateReqDto.toDelivery()));
        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(deliveryUpdateReqDto.toDelivery());
        return SuccessResponse.ok(resDto);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<SuccessResponse<?>> getDelivery(@RequestParam(name = "deliveryId") final Long deliveryId) {
//        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(deliveryUpdateUseCase.updateDelivery(deliveryUpdateReqDto.toDelivery()));
        final DeliveryUpdateResDto resDto = DeliveryUpdateResDto.of(Delivery.builder()
            .id(deliveryId).build());
        return SuccessResponse.ok(resDto);
    }

}
