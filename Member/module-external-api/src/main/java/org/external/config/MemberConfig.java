package org.external.config;

import lombok.RequiredArgsConstructor;
import org.domain.MemberMapper;
import org.domain.MemberValidator;
import org.domain.MemberWriter;
import org.rdbms.repository.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberConfig {

    private final MemberRepositoryImpl memberRepositoryImpl;

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
        return new MemberWriter(memberRepositoryImpl, memberMapper);
    }
}
