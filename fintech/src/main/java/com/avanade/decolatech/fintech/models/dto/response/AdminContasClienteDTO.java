package com.avanade.decolatech.fintech.models.dto.response;

import java.util.Date;


public class AdminContasClienteDTO {
	private int id;
	private String agencia;
	private String numeroConta;
	private String nome;
	private Date ultimaMovimentacao;
	private Date ultimoAcesso;
	private boolean ativo;
	
	public AdminContasClienteDTO(int id, String agencia, String numeroConta, String nome, Date ultimaMovimentacao, Date ultimoAcesso, boolean ativo) {
		this.setId(id);
		this.setAgencia(agencia);
		this.setNumeroConta(numeroConta);
		this.setNome(nome);
		this.setUltimaMovimentacao(ultimaMovimentacao);
		this.setUltimoAcesso(ultimoAcesso);
		this.setAtivo(ativo);
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getUltimaMovimentacao() {
		return ultimaMovimentacao;
	}

	public void setUltimaMovimentacao(Date ultimaMovimentacao) {
		this.ultimaMovimentacao = ultimaMovimentacao;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
