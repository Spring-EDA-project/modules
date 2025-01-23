package org.eda.presentation;

import lombok.RequiredArgsConstructor;
import org.common.response.SuccessResponse;
import org.eda.application.port.in.SignUpUseCase;
import org.eda.presentation.dto.req.SignUpReqDto;
import org.eda.presentation.dto.res.SignUpResDto;
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