package com.eda.domain;

import com.eda.rdbms.entity.MemberEntity;

public class MemberMapper {

    public MemberEntity toEntity(Member member) {
        return MemberEntity.builder()
            .id(member.getId())
            .gender(member.getGender())
            .name(member.getName())
            .email(member.getEmail())
            .password(member.getPassword())
            .age(member.getAge())
            .createdAt(member.getCreatedAt())
            .lastModifiedAt(member.getLastModifiedAt())
            .build();
    }

    public Member toDomain(MemberEntity entity) {
        return Member.builder()
            .id(entity.getId())
            .gender(entity.getGender())
            .name(entity.getName())
            .email(entity.getEmail())
            .password(entity.getPassword())
            .age(entity.getAge())
            .createdAt(entity.getCreatedAt())
            .lastModifiedAt(entity.getLastModifiedAt())
            .build();
    }
}
