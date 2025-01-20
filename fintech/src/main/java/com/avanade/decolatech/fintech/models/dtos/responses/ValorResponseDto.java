package com.avanade.decolatech.fintech.models.dtos.responses;

public class ValorResponseDto {
    private double valor;

    public ValorResponseDto(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
