package com.lh.controller;

import com.lh.config.BaiduAIConfig;
import com.lh.pojo.AccessTokenResponse;
import com.lh.pojo.Chat;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RequestMapping("/api/baidu")
@RestController
@Component
public class ChatController {

    private final RestTemplate restTemplate;
    private final BaiduAIConfig baiduAIConfig;
    private final List<Map<String, Object>> conversationHistory = new ArrayList<>();

    @Autowired
    public ChatController(RestTemplate restTemplate, BaiduAIConfig baiduAIConfig) {
        this.restTemplate = restTemplate;
        this.baiduAIConfig = Objects.requireNonNull(baiduAIConfig);
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody Chat chat) {
        try {
            String accessToken = getAccessToken();
            // 创建新消息
            Map<String, Object> newMessage = new HashMap<>();
            newMessage.put("role", chat.getRole());
            newMessage.put("content", chat.getContent());

            // 将新消息追加到历史记录中
            conversationHistory.add(newMessage);

            // 将历史记录作为请求的一部分
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("messages", conversationHistory);

            String apiUrl = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions_pro?access_token=" + accessToken;
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestData, String.class);

            // 更新历史记录，包括助手的回复
            Map<String, Object> newReply = new HashMap<>();
            newReply.put("role", "assistant");
            JSONObject jsonObject = new JSONObject(response.getBody());
            String result = jsonObject.getString("result");
            newReply.put("content", result);
            conversationHistory.add(newReply);

            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getRawStatusCode())
                    .body(e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }


    private String getAccessToken() {
        String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=" +
                baiduAIConfig.getAccessKey() + "&client_secret=" + baiduAIConfig.getSecretKey();

        try {
            AccessTokenResponse response = restTemplate.postForObject(url, null, AccessTokenResponse.class);
            return Objects.requireNonNull(response).getAccess_token();
        } catch (Exception e) {
            throw new RuntimeException("Failed to obtain access token", e);
        }
    }
}
