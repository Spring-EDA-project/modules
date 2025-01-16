package org.external.config;

import org.domain.MemberMapper;
import org.domain.MemberValidator;
import org.domain.MemberWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {
    @Bean
    public MemberValidator memberValidator() {
        return new MemberValidator();
    }

    @Bean
    public MemberMapper memberMapper() {
        return new MemberMapper();
    }

    @Bean
    public MemberWriter memberWriter() {
        MemberMapper memberMapper = new MemberMapper();
        return new MemberWriter(, memberMapper);
    }
}
