package com.avanade.decolatech.fintech.models.entities;

import com.avanade.decolatech.fintech.models.enums.Direcao;
import com.avanade.decolatech.fintech.models.enums.StatusMovimentacao;
import com.avanade.decolatech.fintech.models.enums.TipoMovimentacao;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_MOVIMENTACAO")
public class Movimentacao {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CODIGO_MOVIMENTACAO")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String codigoMovimentacao;

    @Column(name = "STATUS_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private StatusMovimentacao status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CONTA")
    private Conta conta;

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "DIRECAO")
    @Enumerated(EnumType.STRING)
    private Direcao direcao;

    @Column(name = "DATA_HORA")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataMovimentacao;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "VALOR_MOVIMENTACAO")
    private double valorMovimentacao;

    @Column(name = "VALOR_PERCENTUAL_TAXA")
    private double percentualTaxa;

    @Column(name = "VALOR_TOTAL")
    private double valorTotalMovimentacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoMovimentacao() {
        return codigoMovimentacao;
    }

    public void setCodigoMovimentacao(String codigoMovimentacao) {
        this.codigoMovimentacao = codigoMovimentacao;
    }

    public StatusMovimentacao getStatus() {
        return status;
    }

    public void setStatus(StatusMovimentacao status) {
        this.status = status;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(double valorMovimentacao) {
        this.valorMovimentacao = valorMovimentacao;
    }

    public double getPercentualTaxa() {
        return percentualTaxa;
    }

    public void setPercentualTaxa(double percentualTaxa) {
        this.percentualTaxa = percentualTaxa;
    }

    public double getValorTotalMovimentacao() {
        return valorTotalMovimentacao;
    }

    public void setValorTotalMovimentacao(double valorTotalMovimentacao) {
        this.valorTotalMovimentacao = valorTotalMovimentacao;
    }
}
