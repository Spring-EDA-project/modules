package com.eda.external.application.service;

import lombok.RequiredArgsConstructor;
import com.eda.domain.Member;
import com.eda.domain.MemberValidator;
import com.eda.domain.MemberWriter;
import com.eda.external.application.port.in.SignUpUseCase;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService implements SignUpUseCase {
    private final MemberValidator memberValidator;
    private final MemberWriter memberWriter;

    @Override
    public Member signUp(Member member) {
        memberValidator.validatePassword(member);
        return memberWriter.write(member);
    }
}