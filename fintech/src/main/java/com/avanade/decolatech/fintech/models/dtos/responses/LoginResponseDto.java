package com.avanade.decolatech.fintech.models.dtos.responses;

public class LoginResponseDto {
    private String accessToken;
    private Long expiresIn;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String accessToken, Long expiresIn) {
        this.setAccessToken(accessToken);
        this.setExpiresIn(expiresIn);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
