package org.domain.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
}
