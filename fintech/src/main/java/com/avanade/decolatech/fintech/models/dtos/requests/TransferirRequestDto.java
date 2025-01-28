package com.avanade.decolatech.fintech.models.dtos.requests;

public class TransferirRequestDto {
    private double valor;
    private int destino;
    private String descricao;

    public TransferirRequestDto(double valor, int destino, String descricao) {
        this.setValor(valor);
        this.setDestino(destino);
        this.setDescricao(descricao);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
