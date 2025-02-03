package com.eda.external.application.port.in;

import com.eda.domain.Member;

public interface SignUpUseCase {
    Member signUp(Member member);
}