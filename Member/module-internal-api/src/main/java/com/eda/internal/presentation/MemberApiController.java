package com.eda.internal.presentation;

import com.eda.global.common.response.BaseResponse;
import com.eda.internal.application.port.in.GetMemberUseCase;
import com.eda.internal.presentation.dto.res.MemberResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/internal/member")
@RestController
public class MemberApiController {
    private final GetMemberUseCase getMemberUseCase;
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> getMember(@PathVariable final Long id){
        final MemberResDto resDto = MemberResDto.of(getMemberUseCase.getMemberInfo(id));
        return BaseResponse.ok(resDto);
    }
}