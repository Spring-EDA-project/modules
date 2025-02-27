package com.eda.messaging.service;

import com.eda.messaging.config.AwsSnsConfig;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsService {

    private final SnsClient snsClient;

    public SnsService(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public PublishResponse publish(String topicArn, String subject, String messageGroup, String message) {

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topicArn)
                .subject(subject)
                .messageGroupId(messageGroup)
                .message(message)
                .build();

//        SnsClient snsClient = awsSnsConfig.getSnsClient();
        return snsClient.publish(publishRequest);
    }

    public PublishResponse publish(String topicArn, String subject, String message) {

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topicArn)
                .subject(subject)
                .message(message)
                .build();

//        SnsClient snsClient = awsSnsConfig.getSnsClient();
        return snsClient.publish(publishRequest);
    }
}
