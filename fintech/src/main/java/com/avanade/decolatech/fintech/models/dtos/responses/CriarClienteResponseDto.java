package com.avanade.decolatech.fintech.models.dtos.responses;

public class CriarClienteResponseDto {
    private String accessToken;
    private String agencia;
    private String conta;
    private String senhaPagamento;

    public CriarClienteResponseDto() {
    }

    public CriarClienteResponseDto(String accessToken, String agencia, String conta, String senhaPagamento) {
        this.setAccessToken(accessToken);
        this.setAgencia(agencia);
        this.setConta(conta);
        this.setSenhaPagamento(senhaPagamento);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSenhaPagamento() {
        return senhaPagamento;
    }

    public void setSenhaPagamento(String senhaPagamento) {
        this.senhaPagamento = senhaPagamento;
    }
}
