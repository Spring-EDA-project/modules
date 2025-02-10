package org.eda.external.presentation;

import lombok.RequiredArgsConstructor;
import org.eda.common.response.SuccessResponse;
import org.eda.external.application.port.in.GetAllOrdersUseCase;
import org.eda.external.application.port.in.GetOrderUseCase;
import org.eda.external.application.port.in.MakeOrderUseCase;
import org.eda.external.presentation.dto.req.MakeOrderReqDto;
import org.eda.external.presentation.dto.res.GetAllOrdersResDto;
import org.eda.external.presentation.dto.res.GetOrderResDto;
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
    public ResponseEntity<SuccessResponse<?>> makeOrder(@RequestBody final MakeOrderReqDto makeOrderReqDto) {
        makeOrderUseCase.makeOrder();
        return SuccessResponse.ok(null);
    }

    /** 내 주문 단일 조회 API */
    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<SuccessResponse<?>> getOrder(
            @PathVariable final Long orderId,
            @PathVariable final Long userId
    ) {
        final GetOrderResDto resDto = GetOrderResDto.of(getOrderUseCase.getOrder(userId, orderId));
        return SuccessResponse.ok(null);
    }

    /** 내 주문 전체 조회 API */
    @GetMapping("/{userId}")
    public ResponseEntity<SuccessResponse<?>> getAllOrders(@PathVariable final Long userId) {
        final GetAllOrdersResDto resDto = GetAllOrdersResDto.of(getAllOrdersUseCase.getAllOrders(0L));
        return SuccessResponse.ok(null);
    }
}
