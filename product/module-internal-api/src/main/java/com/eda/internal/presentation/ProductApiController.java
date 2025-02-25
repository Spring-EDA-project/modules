package com.eda.internal.presentation;

import com.eda.common.response.SuccessResponse;
import com.eda.internal.presentation.dto.res.GetProductResDto;
import com.eda.internal.application.port.in.GetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductApiController {

    private final GetProductUseCase getProductUseCase;

    /** 상품 단일 조회 API */
    @GetMapping("/{productId}")
    public ResponseEntity<SuccessResponse<?>> getProduct(@PathVariable final Long productId) {
        final GetProductResDto resDto = GetProductResDto.of(getProductUseCase.getProduct(productId));
        return SuccessResponse.ok(resDto);
    }
}
