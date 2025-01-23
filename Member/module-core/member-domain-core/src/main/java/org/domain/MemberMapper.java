package org.domain;

import org.eda.entity.MemberEntity;

public class MemberMapper {

    public MemberEntity toEntity(Member member) {
        return MemberEntity.builder()
                .email(member.getEmail())
                .name(member.getName())
                .password(member.getPassword())
                .build();
    }

    public Member toDomain(MemberEntity entity) {
        return Member.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }
}
