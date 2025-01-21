package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoConta;

public class ContaResponseDto {
    private int agencia;
    private int numeroConta;
    private TipoConta tipoConta;

    public ContaResponseDto(
            int agencia,
            int numeroConta,
            TipoConta tipoConta
    ) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
