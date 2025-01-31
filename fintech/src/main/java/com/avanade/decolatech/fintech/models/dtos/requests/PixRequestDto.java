package com.avanade.decolatech.fintech.models.dtos.requests;

public class PixRequestDto {
    private String chave;
    private double valor;
    private String descricao;

    public PixRequestDto(String chave, double valor, String descricao) {
        this.setChave(chave);
        this.setValor(valor);
        this.setDescricao(descricao);
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
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
