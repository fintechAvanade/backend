package com.avanade.decolatech.fintech.models.entities;

import com.avanade.decolatech.fintech.models.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CONTA")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "AGENCIA")
	private String agencia;
	
	@Column(name = "NUMERO_CONTA")
	private String numeroConta;
	
	@Column(name = "SALDO")
	private double saldo;
	
	@Column(name = "HASH_SENHA_PAGAMENTO")
	private String hashSenhaPagamento;
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
	@Column(name = "TIPO_CONTA")
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<Movimentacao> movimentacoes;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conta")
	private List<ContaInvestimento> contasInvestimentos;

	@Transient
	private String senhaPagamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getHashSenhaPagamento() {
		return hashSenhaPagamento;
	}

	public void setHashSenhaPagamento(String hashSenhaPagamento) {
		this.hashSenhaPagamento = hashSenhaPagamento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public List<ContaInvestimento> getContasInvestimentos() {
		return contasInvestimentos;
	}

	public void setContasInvestimentos(List<ContaInvestimento> contasInvestimentos) {
		this.contasInvestimentos = contasInvestimentos;
	}

	public String getSenhaPagamento() {
		return senhaPagamento;
	}

	public void setSenhaPagamento(String senhaPagamento) {
		this.senhaPagamento = senhaPagamento;
	}
}
