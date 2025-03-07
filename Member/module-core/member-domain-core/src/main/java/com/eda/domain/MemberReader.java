package com.eda.domain;

import com.eda.global.common.error.exception.EntityNotFoundException;
import com.eda.global.common.error.exception.UnauthorizedException;
import com.eda.rdbms.entity.MemberEntity;
import com.eda.rdbms.repository.ports.in.MemberRepository;

public class MemberReader {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberReader(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public Member readByEmail(String email) {
        MemberEntity memberEntity = memberRepository.findByEmail(email);
        return memberMapper.toDomain(memberEntity);
    }

    public Member readById(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id);
        return memberMapper.toDomain(memberEntity);
    }
}
