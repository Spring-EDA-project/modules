package com.eda.messaging.service;

import com.eda.messaging.config.MessageProcessor;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SqsListener {
    private final SqsAsyncClient sqsAsyncClient;
    private final MessageProcessor messageProcessor;

    public SqsListener(SqsAsyncClient sqsAsyncClient, List<Object> handlers) {
        this.sqsAsyncClient = sqsAsyncClient;
        this.messageProcessor = new MessageProcessor(handlers);
    }

    @PostConstruct
    public void init() {
        pollAllQueues();
        log.info("SqsListener initialized");
    }

    @Scheduled(fixedDelay = 5000)
    public void pollAllQueues() {
        messageProcessor.getAllQueueUrls().forEach(this::pollMessages);
    }

    public void pollMessages(String queueUrl) {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .waitTimeSeconds(10) // Long Polling 적용
                .build();

        CompletableFuture<ReceiveMessageResponse> futureResponse = sqsAsyncClient.receiveMessage(request);

        futureResponse.thenAccept(response -> {
            response.messages().forEach(message -> {
                try {
                    messageProcessor.process(message.body(), queueUrl);
                } catch (Exception e) {
                    log.error("Error processing message", e);
                }
                deleteMessage(queueUrl, message.receiptHandle());
            });
        });
    }

    private void deleteMessage(String queueUrl, String receiptHandle) {
        DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                .queueUrl(queueUrl)
                .receiptHandle(receiptHandle)
                .build();
        sqsAsyncClient.deleteMessage(deleteRequest);
    }
}
