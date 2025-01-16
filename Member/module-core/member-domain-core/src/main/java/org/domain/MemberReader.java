package org.domain;

import org.rdbms.impl.MemberRepository;

public class MemberReader {
    private final MemberRepository memberRepository;

    public MemberReader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
