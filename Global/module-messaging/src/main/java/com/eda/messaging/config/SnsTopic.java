package com.eda.messaging.config;

import java.util.Map;

public class SnsTopic {
    private Map<String, String> topic;

    public Map<String, String> getTopic() {
        return topic;
    }

    public void setTopic(Map<String, String> topic) {
        this.topic = topic;
    }

    public String getTopicArn(String topicName) {
        return topic.get(topicName);
    }
}
