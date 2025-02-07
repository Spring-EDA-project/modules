package com.eda.external.presentation.dto.req;

import com.eda.domain.Member;

public record LoginReqDto(
    String email,
    String password
) {
    public Member toMember() {
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}