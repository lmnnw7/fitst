package com.lh.controller;

import com.lh.config.BaiduAIConfig;
import com.lh.pojo.AccessTokenResponse;
import com.lh.pojo.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class ChatController {

    private final RestTemplate restTemplate;
    private final BaiduAIConfig baiduAIConfig; // Inject BaiduAIConfig

    @Autowired
    public ChatController(RestTemplateBuilder restTemplateBuilder, BaiduAIConfig baiduAIConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.baiduAIConfig = baiduAIConfig;
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest chatRequest) {
        String accessToken = getAccessToken();
        String apiUrl = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions_pro?access_token=" + accessToken;

        return restTemplate.postForEntity(apiUrl, chatRequest, String.class);
    }

    private String getAccessToken() {
        String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=" +
                baiduAIConfig.getAccessKey() + "&client_secret=" + baiduAIConfig.getSecretKey();

        AccessTokenResponse response = restTemplate.postForObject(url, null, AccessTokenResponse.class);
        assert response != null;
        return response.getAccess_token();
    }
}
