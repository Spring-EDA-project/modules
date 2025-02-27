package com.eda.messaging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "eda.aws")
public class AwsProperties {
    private String accessKey;
    private String secretKey;
    private String region;

    @NestedConfigurationProperty
    private SnsTopic snstopic;

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public SnsTopic getSnstopic() {
        return snstopic;
    }

    public void setSnstopic(SnsTopic snstopic) {
        this.snstopic = snstopic;
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
