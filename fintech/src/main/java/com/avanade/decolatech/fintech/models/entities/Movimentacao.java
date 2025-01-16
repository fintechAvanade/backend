package com.avanade.decolatech.fintech.models.entities;

import com.avanade.decolatech.fintech.models.enums.Direcao;
import com.avanade.decolatech.fintech.models.enums.StatusMovimentacao;
import com.avanade.decolatech.fintech.models.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "TB_MOVIMENTACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimentacao {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CODIGO_MOVIMENTACAO")
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

}
