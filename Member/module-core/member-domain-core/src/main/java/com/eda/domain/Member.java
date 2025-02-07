package com.eda.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;

    public boolean isPasswordMatch(String password) {
        return this.password.equals(password);
    }
}
