package com.lh.pojo;

import lombok.Data;

@Data
public class AccessTokenResponse {
    private String access_token;
    private String session_key;
    private String scope;
    private String refresh_token;
    private String session_secret;

    // getters and setters
}
