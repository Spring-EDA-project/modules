package com.eda.external.presentation;

import com.eda.external.application.port.in.GetMemberUseCase;
import com.eda.external.application.port.in.LoginUseCase;
import com.eda.external.presentation.dto.req.LoginReqDto;
import com.eda.external.presentation.dto.res.LoginResDto;
import com.eda.external.presentation.dto.res.MemberResDto;
import com.eda.global.common.error.GlobalExceptionHandler;
import com.eda.global.common.error.exception.BadRequestException;
import com.eda.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import com.eda.external.application.port.in.SignUpUseCase;
import com.eda.external.presentation.dto.req.SignUpReqDto;
import com.eda.external.presentation.dto.res.SignUpResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberApiController {
    private final SignUpUseCase signUpUseCase;
    private final LoginUseCase loginUseCase;
    private final GetMemberUseCase getMemberUseCase;

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<?>> signup(@RequestBody final SignUpReqDto signUpReqDto) {
        final SignUpResDto resDto = SignUpResDto.of(signUpUseCase.signUp(signUpReqDto.toMember()));
        return BaseResponse.created(resDto);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<?>> login(@RequestBody final LoginReqDto loginReqDto){
        final LoginResDto resDto = LoginResDto.of(loginUseCase.login(loginReqDto.toMember()));
        return BaseResponse.ok(resDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<?>> getMember(@PathVariable final Long id){
        final MemberResDto resDto = MemberResDto.of(getMemberUseCase.getMemberInfo(id));
        return BaseResponse.ok(resDto);
    }
}