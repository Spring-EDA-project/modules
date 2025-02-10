package com.eda.rdbms.external.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EntityScan(basePackages = "com.eda.rdbms.entity")
@EnableJpaRepositories(basePackages = "com.eda.rdbms.repository")
@Configuration
public class JpaConfig {
}
