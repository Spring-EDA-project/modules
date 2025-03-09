package com.eda.internal.application.service;

import com.eda.domain.Member;
import com.eda.domain.MemberReader;
import com.eda.internal.application.port.in.GetMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMemberService implements GetMemberUseCase {
    private final MemberReader memberReader;
    @Override
    public Member getMemberInfo(Long id) {
        return memberReader.readById(id);
    }
}
