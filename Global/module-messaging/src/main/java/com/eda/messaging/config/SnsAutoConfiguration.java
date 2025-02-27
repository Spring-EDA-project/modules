package com.eda.messaging.config;

import com.eda.messaging.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
@ConditionalOnClass(SnsService.class)
@EnableConfigurationProperties(AwsProperties.class)
public class SnsAutoConfiguration {

    @Autowired
    private AwsProperties awsProperties;

    @Bean
    @ConditionalOnMissingBean
    public SnsClient getSnsClient() {
        return SnsClient.builder()
                .credentialsProvider(() -> AwsBasicCredentials.create(awsProperties.getAccessKey(), awsProperties.getSecretKey()))
                .region(Region.of(awsProperties.getRegion()))
                .build();
    }
}
