package com.avanade.decolatech.fintech.models.dtos.responses;

import java.util.Date;

public class InfoContasResponseDto {
	private int id;
	private String agencia;
	private String numeroConta;
	private String nome;
	private String cpf;
	private Date ultimaMovimentacao;
	private Date ultimoAcesso;
	private boolean ativo;

	public InfoContasResponseDto(int id, String agencia, String numeroConta, String nome, String cpf, Date ultimaMovimentacao, Date ultimoAcesso, boolean ativo) {
		this.setId(id);
		this.setAgencia(agencia);
		this.setNumeroConta(numeroConta);
		this.setNome(nome);
		this.setCpf(cpf);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
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