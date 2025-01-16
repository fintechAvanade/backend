package com.avanade.decolatech.fintech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_CONTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "AGENCIA")
	private int agencia;
	
	@Column(name = "NUMERO_CONTA")
	private int numeroConta;
	
	@Column(name = "SALDO")
	private double saldo;
	
	@Column(name = "HASH_SENHA_PAGAMENTO")
	private String hashSenhaPagamento;
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
	@Column(name = "TIPO_CONTA")
	private char tipoConta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Movimentacao> movimentacoes;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<ContaInvestimento> contasInvestimentos;
}
