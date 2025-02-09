package com.eda.messaging.service;

import com.eda.messaging.config.AwsSnsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SqsService {
    private final AwsSnsConfig awsSnsConfig;
    private final ObjectMapper objectMapper;

    public SqsService(AwsSnsConfig awsSnsConfig, ObjectMapper objectMapper) {
        this.awsSnsConfig = awsSnsConfig;
        this.objectMapper = objectMapper;
    }

    @SqsListener(value = "EdaQueue", factory = "defaultSqsMessageListenerContainerFactory")
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
