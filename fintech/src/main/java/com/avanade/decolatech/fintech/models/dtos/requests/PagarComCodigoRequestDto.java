package com.avanade.decolatech.fintech.models.dtos.requests;

public class PagarComCodigoRequestDto {
    private String codigo;
    private double valor;
    private String descricao;

    public PagarComCodigoRequestDto() {
    }

    public PagarComCodigoRequestDto(String codigo, double valor, String descricao) {
        this.setCodigo(codigo);
        this.setValor(valor);
        this.setDescricao(descricao);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
