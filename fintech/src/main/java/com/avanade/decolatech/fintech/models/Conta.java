package com.avanade.decolatech.fintech.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTA")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
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

	public char getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(char tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
