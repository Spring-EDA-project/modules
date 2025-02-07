package com.eda.external.application.port.in;

import com.eda.domain.Member;
import com.eda.external.presentation.dto.req.LoginReqDto;

public interface LoginUseCase {

    Member login(Member member);
}
