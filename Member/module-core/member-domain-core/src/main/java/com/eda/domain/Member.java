package com.eda.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String gender;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;


    public boolean isPasswordMatch(String password) {
        return this.password.equals(password);
    }
}
