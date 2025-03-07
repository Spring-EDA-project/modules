package com.eda.external.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import com.eda.domain.Member;

@Builder(access = AccessLevel.PRIVATE)
public record SignUpResDto(
    Long id,
    String name,
    String email
) {
    public static SignUpResDto of(Member member) {
        return SignUpResDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}
