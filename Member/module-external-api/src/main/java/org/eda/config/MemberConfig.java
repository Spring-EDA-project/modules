package org.eda.config;

import lombok.RequiredArgsConstructor;
import org.eda.MemberMapper;
import org.eda.MemberValidator;
import org.eda.MemberWriter;
import org.eda.repository.MemberRepositoryImpl;
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
