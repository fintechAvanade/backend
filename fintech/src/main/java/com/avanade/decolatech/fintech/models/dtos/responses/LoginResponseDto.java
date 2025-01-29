package com.avanade.decolatech.fintech.models.dtos.responses;

public class LoginResponseDto {
    private String accessToken;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String accessToken) {
        this.setAccessToken(accessToken);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
