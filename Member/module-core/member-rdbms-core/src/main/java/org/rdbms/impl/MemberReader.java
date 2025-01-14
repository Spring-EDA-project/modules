package org.rdbms.impl;


import lombok.RequiredArgsConstructor;
import org.rdbms.repository.MemberRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberReader {
    private final MemberRepository memberRepository;

    public void read() {
        memberRepository.findById()
                .orElseThrow(() -> );
    }
}
