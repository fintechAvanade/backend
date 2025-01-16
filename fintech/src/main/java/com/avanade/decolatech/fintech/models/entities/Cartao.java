package com.avanade.decolatech.fintech.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "TB_CARTAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
}
