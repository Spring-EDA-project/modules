package org.external.application.port.in;

import org.external.application.port.in.dto.req.SignUpReqDto;
import org.external.application.port.in.dto.res.SignUpResDto;

public interface SignUpUseCase {
    SignUpResDto signUp(SignUpReqDto signUpReqDto);
}