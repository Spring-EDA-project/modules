package org.external.config;

import org.domain.MemberMapper;
import org.domain.MemberValidator;
import org.domain.MemberWriter;
import org.rdbms.repository.MemberRepositoryImpl;
import org.rdbms.repository.ports.in.MemberRepository;
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
    public MemberRepository memberRepository() {return new MemberRepositoryImpl();}

    @Bean
    public MemberWriter memberWriter() {
        MemberMapper memberMapper = new MemberMapper();
        return new MemberWriter(this.memberRepository(), memberMapper);
    }
}
