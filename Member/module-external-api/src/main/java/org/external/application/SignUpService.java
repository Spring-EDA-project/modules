package org.external.application;

import lombok.RequiredArgsConstructor;
import org.domain.Member;
//import org.domain.MemberValidator;
//import org.domain.MemberWriter;
import org.external.application.port.in.SignUpUseCase;
import org.rdbms.repository.ports.in.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService implements SignUpUseCase {
//    private final MemberValidator memberValidator;
//    private final MemberWriter memberWriter;
    private final MemberRepository memberRepository;

    @Override
    public Member signUp(Member member) {
//        memberValidator.validatePassword(member);
//        return memberWriter.write(member);
        return null;
    }
}