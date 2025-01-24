package com.eda.domain;

import com.eda.rdbms.entity.MemberEntity;
import com.eda.rdbms.repository.ports.in.MemberRepository;

public class MemberWriter {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberWriter(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public Member write(Member member) {
        MemberEntity memberEntity = memberMapper.toEntity(member);
        MemberEntity savedMemberEntity = memberRepository.save(memberEntity);
        return memberMapper.toDomain(savedMemberEntity);
    }
}