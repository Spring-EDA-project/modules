package com.eda.messaging.config;

import com.eda.messaging.service.SqsListener;
import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@ConditionalOnClass(SqsListener.class)
@EnableConfigurationProperties(AwsProperties.class)
public class SqsAutoConfiguration {

    @Autowired
    private AwsProperties awsProperties;

    @Bean
    @ConditionalOnMissingBean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .credentialsProvider(() -> new AwsCredentials() {
                    @Override
                    public String accessKeyId() {
                        return awsProperties.getAccessKey();
                    }

                    @Override
                    public String secretAccessKey() {
                        return awsProperties.getSecretKey();
                    }
                })
                .region(Region.of(awsProperties.getRegion()))
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public SqsMessageListenerContainerFactory<Object> defaultSqsMessageListenerContainerFactory() {
        return SqsMessageListenerContainerFactory
                .builder()
                .sqsAsyncClient(sqsAsyncClient())
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public QueueProperties queueProperties() {
        return new QueueProperties(awsProperties.getSqsUrls());
    }
}
