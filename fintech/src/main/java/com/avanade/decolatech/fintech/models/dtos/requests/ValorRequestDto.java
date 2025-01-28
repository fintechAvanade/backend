package com.avanade.decolatech.fintech.models.dtos.requests;

public class ValorRequestDto {
    private double valor;
    private String descricao;

    public ValorRequestDto(double valor, String descricao){
        this.setValor(valor);
        this.setDescricao(descricao);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
