package com.eda.external.config;

import lombok.RequiredArgsConstructor;
import com.eda.domain.MemberMapper;
import com.eda.domain.MemberValidator;
import com.eda.domain.MemberWriter;
import com.eda.rdbms.repository.MemberRepositoryImpl;
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
