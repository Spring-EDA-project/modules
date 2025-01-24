package com.eda.external.presentation;

import lombok.RequiredArgsConstructor;
import com.eda.common.response.SuccessResponse;
import com.eda.external.application.port.in.SignUpUseCase;
import com.eda.external.presentation.dto.req.SignUpReqDto;
import com.eda.external.presentation.dto.res.SignUpResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberApiController {
    private final SignUpUseCase signUpUseCase;

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse<?>> signup(@RequestBody final SignUpReqDto signUpReqDto) {
        final SignUpResDto resDto = SignUpResDto.of(signUpUseCase.signUp(signUpReqDto.toMember()));
        return SuccessResponse.ok(resDto);
    }
}