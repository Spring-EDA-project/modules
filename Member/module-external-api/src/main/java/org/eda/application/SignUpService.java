package org.eda.application;

import lombok.RequiredArgsConstructor;
import org.eda.Member;
import org.eda.MemberValidator;
import org.eda.MemberWriter;
import org.eda.application.port.in.SignUpUseCase;
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