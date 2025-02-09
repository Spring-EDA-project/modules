package com.eda.messaging.service;

import com.eda.base.config.TestAwsSDKConfig;
import com.eda.messaging.config.AwsSnsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sns.SnsClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        classes = {TestAwsSDKConfig.class},
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@ActiveProfiles("test_standalone")
class SnsServiceTest {

    @Autowired
    private SnsService snsService;

    @Test
    void pushMessage() {
        String subject = "test subject";
        String messageGroup = "testMessageGroup";
        String message = "test message";
        Map<String, Object> messageData = Map.of("message", message);

        snsService.publish(subject, messageGroup, messageData);
    }
}