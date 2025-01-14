package org.external.application;

import lombok.RequiredArgsConstructor;
import org.external.application.port.in.SignUpUseCase;
import org.external.application.port.in.dto.req.SignUpReqDto;
import org.external.application.port.in.dto.res.SignUpResDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService implements SignUpUseCase {

    @Override
    public SignUpResDto signUp(SignUpReqDto signUpReqDto) {
        return null;
    }
}