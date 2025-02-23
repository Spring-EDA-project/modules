package com.eda.external.presentation;

import lombok.RequiredArgsConstructor;
import com.eda.common.response.SuccessResponse;
import com.eda.external.application.port.in.GetAllProductsUseCase;
import com.eda.external.application.port.in.GetProductUseCase;
import com.eda.external.presentation.dto.res.GetAllProductsResDto;
import com.eda.external.presentation.dto.res.GetProductResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductApiController {

    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetProductUseCase getProductUseCase;

    /** 상품 전체 조회 API */
    @GetMapping("/{productId}")
    public ResponseEntity<SuccessResponse<?>> getProduct(@PathVariable final Long productId) {
        final GetProductResDto resDto = GetProductResDto.of(getProductUseCase.getProduct(productId));
        return SuccessResponse.ok(resDto);
    }

    /** 상품 단일 조회 API */
    @GetMapping
    public ResponseEntity<SuccessResponse<?>> getProduct() {
        final GetAllProductsResDto resDto = GetAllProductsResDto.of(getAllProductsUseCase.getAllProducts());
        return SuccessResponse.ok(resDto);
    }
}
