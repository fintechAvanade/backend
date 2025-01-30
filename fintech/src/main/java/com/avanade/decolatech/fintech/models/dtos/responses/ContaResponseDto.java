package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoConta;

public class ContaResponseDto {
    private String agencia;
    private String numeroConta;
    private String tipoConta;

    public ContaResponseDto(
            String agencia,
            String numeroConta,
            String tipoConta
    ) {
        this.setAgencia(agencia);
        this.setNumeroConta(numeroConta);
        this.setTipoConta(tipoConta);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}