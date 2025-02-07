package com.eda.external.presentation.dto.res;

import com.eda.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record LoginResDto(
    String name,
    String email
) {
    public static LoginResDto of(Member member) {
        return LoginResDto.builder()
            .name(member.getName())
            .email(member.getEmail())
            .build();
    }
}
