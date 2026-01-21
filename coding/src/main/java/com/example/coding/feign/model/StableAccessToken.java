package com.example.coding.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

public class StableAccessToken {
    private StableAccessToken() {
    }

    @Data
    public static class Request implements Serializable {
        @JsonProperty("appid")
        private String appId;
        private String secret;
        @JsonProperty("grant_type")
        private String grantType = "client_credential";
    }

    @Data
    public static class Response implements Serializable {
        @JsonProperty("access_token")
        private String token;
        @JsonProperty("expires_in")
        private int expiresIn;
    }
}
