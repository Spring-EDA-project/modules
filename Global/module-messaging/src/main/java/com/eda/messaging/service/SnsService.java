package com.eda.messaging.service;

import com.eda.messaging.config.AwsSnsConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

import java.util.Map;

@Service
public class SnsService {

    private final AwsSnsConfig awsSnsConfig;
    private final ObjectMapper objectMapper;

    public SnsService(AwsSnsConfig awsSnsConfig, ObjectMapper objectMapper) {
        this.awsSnsConfig = awsSnsConfig;
        this.objectMapper = objectMapper;
    }

    public PublishResponse publish(String subject, String messageGroup, Map<String, Object> messageData) {
        String messageJson = convertMessageDataToJson(messageData);

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(awsSnsConfig.getTopicArn())
                .subject(subject)
                .messageGroupId(messageGroup)
                .message(messageJson)
                .build();

        SnsClient snsClient = awsSnsConfig.getSnsClient();
        return snsClient.publish(publishRequest);
    }

    public PublishResponse publish(String subject, Map<String, Object> messageData) {
        String messageJson = convertMessageDataToJson(messageData);

        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(awsSnsConfig.getTopicArn())
                .subject(subject)
                .message(messageJson)
                .build();

        SnsClient snsClient = awsSnsConfig.getSnsClient();
        return snsClient.publish(publishRequest);
    }

    private String convertMessageDataToJson(Map<String, Object> messageData) {
        try {
            return objectMapper.writeValueAsString(messageData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert message data to JSON", e);
        }
    }

}
