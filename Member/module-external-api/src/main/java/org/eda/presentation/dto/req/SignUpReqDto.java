package org.eda.presentation.dto.req;

import org.domain.Member;

public record SignUpReqDto(
        String email,
        String password,
        String name
) {
    public Member toMember() {
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }
}
