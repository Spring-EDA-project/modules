package com.eda.messaging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SqsListener {
    private final SqsAsyncClient sqsAsyncClient;

    public SqsListener(SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    @Scheduled(fixedDelay = 5000) // 5초마다 실행
    public void pollMessages(String queueUrl) {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .waitTimeSeconds(10) // Long Polling 적용
                .build();

        CompletableFuture<ReceiveMessageResponse> futureResponse = sqsAsyncClient.receiveMessage(request);

        futureResponse.thenAccept(response -> {
            response.messages().forEach(message -> {
                System.out.println("Received message: " + message.body());

                // 메시지 처리 후 삭제
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

    @io.awspring.cloud.sqs.annotation.SqsListener(value = "EdaQueue", factory = "defaultSqsMessageListenerContainerFactory")
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
