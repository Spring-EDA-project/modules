package com.eda.messaging.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

public class AwsSnsConfig {
    private String accessKey;
    private String secretKey;
    private String region;
    private String topicArn;

    @Bean
    public SnsClient getSnsClient() {
        return SnsClient.builder()
                .credentialsProvider(() -> AwsBasicCredentials.create(accessKey, secretKey))
                .region(Region.of(region))
                .build();
    }
}
