package com.eda.external.presentation.dto.req;

import com.eda.domain.Member;

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
