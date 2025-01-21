package com.avanade.decolatech.fintech.models.dtos.responses;

import java.util.Date;

public class CartaoResponseDto {
    private String numeroConta;
    private String titular;
    private Date dataExpiracao;
    private String cvv;

    public CartaoResponseDto() {
    }

    public CartaoResponseDto(String numeroConta, String titular, Date dataExpiracao, String cvv) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
