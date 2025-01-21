package com.avanade.decolatech.fintech.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_CARTAO")
public class Cartao {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTA")
    private Conta conta;

    @Column(name = "NUMERO_CARTAO")
    private String numeroCartao;

    @Column(name = "CVV")
    private String cvv;

    @Column(name = "VALIDADE_CARTAO")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataValidadeCartao;

    @Column(name = "ATIVO")
    private boolean ativo;

    public Cartao() {
    }

    public Cartao(int id, Conta conta, String numeroCartao, String cvv, Date dataValidadeCartao, boolean ativo) {
        this.setId(id);
        this.setConta(conta);
        this.setNumeroCartao(numeroCartao);
        this.setCvv(cvv);
        this.setDataValidadeCartao(dataValidadeCartao);
        this.setAtivo(ativo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getDataValidadeCartao() {
        return dataValidadeCartao;
    }

    public void setDataValidadeCartao(Date dataValidadeCartao) {
        this.dataValidadeCartao = dataValidadeCartao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
