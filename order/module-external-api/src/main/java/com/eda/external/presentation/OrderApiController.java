package com.eda.external.presentation;

import lombok.RequiredArgsConstructor;
import com.eda.common.response.SuccessResponse;
import com.eda.external.application.port.in.GetAllOrdersUseCase;
import com.eda.external.application.port.in.GetOrderUseCase;
import com.eda.external.application.port.in.MakeOrderUseCase;
import com.eda.external.presentation.dto.req.MakeOrderReqDto;
import com.eda.external.presentation.dto.res.GetAllOrdersResDto;
import com.eda.external.presentation.dto.res.GetOrderResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/order")
@RestController
public class OrderApiController {

    private final MakeOrderUseCase makeOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;

    /** 주문 요청 API */
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> makeOrder(
            @RequestHeader final Long memberId,
            @RequestBody final MakeOrderReqDto makeOrderReqDto
    ) {
        makeOrderUseCase.makeOrder(makeOrderReqDto.toOrderProducts(), memberId);
        return SuccessResponse.ok(null);
    }

    /** 내 주문 단일 조회 API */
    @GetMapping("/me/{orderId}")
    public ResponseEntity<SuccessResponse<?>> getOrder(
            @PathVariable final Long orderId,
            @RequestHeader final Long memberId
    ) {
        final GetOrderResDto resDto = GetOrderResDto.of(getOrderUseCase.getOrder(memberId, orderId));
        return SuccessResponse.ok(resDto);
    }

    /** 내 주문 전체 조회 API */
    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getAllOrders(@RequestHeader final Long memberId) {
        final GetAllOrdersResDto resDto = GetAllOrdersResDto.of(getAllOrdersUseCase.getAllOrders(memberId));
        return SuccessResponse.ok(resDto);
    }
}
