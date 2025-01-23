package org.eda;

import org.eda.repository.ports.in.MemberRepository;

public class MemberReader {
    private final MemberRepository memberRepository;

    public MemberReader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
