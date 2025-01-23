package org.eda;

import org.eda.entity.MemberEntity;
import org.eda.repository.ports.in.MemberRepository;

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