package com.avanade.decolatech.fintech.models.dtos.requests;

public class TransferirRequestDto {
    private String agencia;
    private String conta;
    private double valor;
    private String descricao;

    public TransferirRequestDto(String agencia, String conta, double valor, String descricao) {
        this.setAgencia(agencia);
        this.setConta(conta);
        this.setValor(valor);
        this.setDescricao(descricao);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
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
