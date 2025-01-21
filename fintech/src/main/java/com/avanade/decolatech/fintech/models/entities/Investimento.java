package com.avanade.decolatech.fintech.models.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_INVESTIMENTO")
public class Investimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NOME_INVESTIMENTO")
	private String nomeInvestimento;
	
	@Column(name = "RENDIMENTO_DIARIO")
	private double rendimentoDiario;
	
	@Column(name = "RESGATE_ANTECIPADO")
	private boolean resgateAntecipado;
	
	@Column(name = "PREVISAO_RESGATE")
	private Date previsaoResgate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "investimento")
	private List<ContaInvestimento> contasInvestimentos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeInvestimento() {
		return nomeInvestimento;
	}

	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}

	public double getRendimentoDiario() {
		return rendimentoDiario;
	}

	public void setRendimentoDiario(double rendimentoDiario) {
		this.rendimentoDiario = rendimentoDiario;
	}

	public boolean isResgateAntecipado() {
		return resgateAntecipado;
	}

	public void setResgateAntecipado(boolean resgateAntecipado) {
		this.resgateAntecipado = resgateAntecipado;
	}

	public Date getPrevisaoResgate() {
		return previsaoResgate;
	}

	public void setPrevisaoResgate(Date previsaoResgate) {
		this.previsaoResgate = previsaoResgate;
	}

	public List<ContaInvestimento> getContasInvestimentos() {
		return contasInvestimentos;
	}

	public void setContasInvestimentos(List<ContaInvestimento> contasInvestimentos) {
		this.contasInvestimentos = contasInvestimentos;
	}
}
