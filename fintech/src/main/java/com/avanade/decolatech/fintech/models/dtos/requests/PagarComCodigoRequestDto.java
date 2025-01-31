package com.avanade.decolatech.fintech.models.dtos.requests;

import com.avanade.decolatech.fintech.models.enums.TipoMovimentacao;

public class PagarComCodigoRequestDto {
    private String codigo;
    private double valor;
    private String descricao;
    private String tipoMovimentacao;

    public PagarComCodigoRequestDto() {
    }

    public PagarComCodigoRequestDto(String codigo, double valor, String descricao, String tipoMovimentacao) {
        this.setCodigo(codigo);
        this.setValor(valor);
        this.setDescricao(descricao);
        this.setTipoMovimentacao(tipoMovimentacao);
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

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
