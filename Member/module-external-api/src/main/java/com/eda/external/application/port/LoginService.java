package com.eda.external.application.port;

import com.eda.domain.Member;
import com.eda.domain.MemberReader;
import com.eda.domain.MemberValidator;
import com.eda.external.application.port.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {
    private final MemberReader memberReader;
    private final MemberValidator memberValidator;
    @Override
    public Member login(Member member) {
        Member foundMember = memberReader.readByEmail(member.getEmail());
        foundMember.isPasswordMatch(member.getPassword());
        return foundMember;
    }
}
