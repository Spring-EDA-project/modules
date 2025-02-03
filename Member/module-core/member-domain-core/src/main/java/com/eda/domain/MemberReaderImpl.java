package com.eda.domain;

import com.eda.rdbms.repository.ports.in.MemberRepository;

public class MemberReaderImpl {
    private final MemberRepository memberRepository;

    public MemberReaderImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
