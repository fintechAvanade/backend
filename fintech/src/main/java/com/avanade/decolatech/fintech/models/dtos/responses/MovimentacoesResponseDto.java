package com.avanade.decolatech.fintech.models.dtos.responses;

import java.util.Date;

public class MovimentacoesResponseDto {
    private String tipoMovimentacao;
    private Date dataMovimentacao;
    private double valor;
    private String direcao;

    public MovimentacoesResponseDto(String tipoMovimentacao, Date dataMovimentacao, double valor, String direcao) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataMovimentacao = dataMovimentacao;
        this.valor = valor;
        this.direcao = direcao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
}
