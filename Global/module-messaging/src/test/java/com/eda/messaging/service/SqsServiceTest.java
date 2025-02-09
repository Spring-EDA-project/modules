package com.eda.messaging.service;

import com.eda.base.config.TestAwsSDKConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(
        classes = {TestAwsSDKConfig.class},
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@ActiveProfiles("test_standalone")
public class SqsServiceTest {

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Autowired
    private SnsService snsService;

    @Autowired
    private SqsService sqsService;

    private static String queueUrl = "https://sqs.ap-northeast-2.amazonaws.com/023013950167/eda-queue.fifo";

    @BeforeEach
    void setUp() {
        // SQS 큐가 존재하는지 확인
        GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder()
                .queueName("EdaQueue")
                .build();
        sqsAsyncClient.getQueueUrl(getQueueUrlRequest);
    }

    @Test
    void pullOneMessage() throws ExecutionException, InterruptedException {
        publishMessage();

        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5) // 최대 5개의 메시지 읽기
                .waitTimeSeconds(10) // 메시지가 없으면 최대 10초 대기
                .build();

        // When: SQS에서 메시지 가져오기
        CompletableFuture<ReceiveMessageResponse> receiveMessageFuture = sqsAsyncClient.receiveMessage(receiveMessageRequest);
        ReceiveMessageResponse receiveMessageResponse = receiveMessageFuture.get();

        List<Message> messages = receiveMessageResponse.messages();

        // Then: 메시지가 존재하는지 검증
        assertFalse(messages.isEmpty(), "SQS 메시지 큐가 비어 있음!");

        for (Message message : messages) {
            System.out.println("Received SQS Message: " + message.body());
        }

        // 메시지 삭제 (테스트 후 정리)
        for (Message message : messages) {
            sqsAsyncClient.deleteMessage(DeleteMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(message.receiptHandle())
                    .build()).get();
        }

    }

    private void publishMessage() {
        String subject = "test subject";
        String messageGroup = "testMessageGroup";
        String message = "test message";
        Map<String, Object> messageData = Map.of("message", message);

        snsService.publish(subject, messageGroup, messageData);
    }
}
