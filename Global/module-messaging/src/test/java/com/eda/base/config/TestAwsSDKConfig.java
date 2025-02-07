package com.eda.base.config;

import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@TestConfiguration
public class TestAwsSDKConfig {

    @Value("${spring.cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${spring.cloud.aws.region.static}")
    private String region;

    @Primary
    @Bean
    public SnsClient getSnsClientTest() {
        return SnsClient.builder()
                .credentialsProvider(() -> AwsBasicCredentials.create(accessKey, secretKey))
                .region(Region.of(region))
                .build();
    }

    @Primary
    @Bean
    public SqsAsyncClient sqsAsyncClientTest() {
        return SqsAsyncClient.builder()
                .credentialsProvider(() -> new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return accessKey;
                    }

                    @Override
                    public String secretAccessKey() {
                        return secretKey;
                    }
                })
                .region(Region.of(region))
                .build();
    }

    @Primary
    @Bean
    public SqsMessageListenerContainerFactory<Object> defaultSqsMessageListenerContainerFactoryTest() {
        return SqsMessageListenerContainerFactory
                .builder()
                .sqsAsyncClient(sqsAsyncClientTest())
                .build();
    }

}
