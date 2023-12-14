package com.lh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaiduAIConfig {

    @Value("${baidu.ai.accessKey}")
    private String accessKey;

    @Value("${baidu.ai.secretKey}")
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
