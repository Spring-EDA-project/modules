package com.eda.messaging.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "eda.aws")
public class AwsProperties {
    private String accessKey;
    private String secretKey;
    private String region;

    private Map<String, String> snsTopics;
    private Map<String, String> sqsUrls;

    public Map<String, String> getSnsTopics() {
        return snsTopics;
    }

    public void setSnsTopics(Map<String, String> snsTopics) {
        this.snsTopics = snsTopics;
    }

    public Map<String, String> getSqsUrls() {
        return sqsUrls;
    }

    public void setSqsUrls(Map<String, String> sqsUrls) {
        this.sqsUrls = sqsUrls;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getRegion() {
        return region;
    }

}
