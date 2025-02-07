package com.eda.domain;

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
//        if(memberEntity == null) {
//            //TODO : null pointer exception handling
//        }
        return memberMapper.toDomain(memberEntity);
    }
}
