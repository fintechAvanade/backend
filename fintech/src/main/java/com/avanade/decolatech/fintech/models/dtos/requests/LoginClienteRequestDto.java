package com.avanade.decolatech.fintech.models.dtos.requests;

public class LoginClienteRequestDto {
    private String agencia;
    private String conta;
    private String senha;


    public LoginClienteRequestDto() {
    }

    public LoginClienteRequestDto(String agencia, String conta, String senha) {
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
