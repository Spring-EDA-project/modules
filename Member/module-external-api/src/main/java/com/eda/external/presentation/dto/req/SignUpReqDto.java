package com.eda.external.presentation.dto.req;

import com.eda.domain.Member;
import java.time.LocalDateTime;

public record SignUpReqDto(
    String gender,
    String name,
    String email,
    String password,
    Integer age
) {
    public Member toMember() {
        return Member.builder()
            .gender(this.gender)
            .age(this.age)
            .email(this.email)
            .password(this.password)
            .name(this.name)
            .createdAt(LocalDateTime.now())
            .lastModifiedAt(LocalDateTime.now())
            .build();
    }
}
