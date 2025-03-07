package com.eda.external.presentation.dto.res;

import com.eda.domain.Member;
import lombok.Builder;

@Builder
public record MemberResDto(
    Long id,
    String gender,
    String name,
    String email,
    Integer age
) {
    public static MemberResDto of(Member member) {
        return MemberResDto.builder()
            .id(member.getId())
            .gender(member.getGender())
            .name(member.getName())
            .email(member.getEmail())
            .age(member.getAge())
            .build();
    }
}
