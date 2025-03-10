package com.eda.messaging.config;

import java.util.Map;

public class QueueProperties {
    Map<String, String> sqsUrls;

    public QueueProperties(Map<String, String> sqsUrls) {
        this.sqsUrls = sqsUrls;
    }

    public String getQueueUrl(String name) {
        return sqsUrls.get(name);
    }
}
