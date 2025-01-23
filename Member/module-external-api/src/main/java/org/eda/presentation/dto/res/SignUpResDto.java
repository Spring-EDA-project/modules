package org.eda.presentation.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import org.domain.Member;

@Builder(access = AccessLevel.PRIVATE)
public record SignUpResDto(
    String name,
    String email,
    String password
) {
    public static SignUpResDto of(Member member) {
        return SignUpResDto.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
