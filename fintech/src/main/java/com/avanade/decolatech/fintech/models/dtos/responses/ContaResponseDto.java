package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoConta;

public class ContaResponseDto {
    private String agencia;
    private String numeroConta;
    private TipoConta tipoConta;

    public ContaResponseDto(
            String agencia,
            String numeroConta,
            TipoConta tipoConta
    ) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
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

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
