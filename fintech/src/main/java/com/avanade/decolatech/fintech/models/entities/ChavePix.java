package com.avanade.decolatech.fintech.models.entities;

import com.avanade.decolatech.fintech.models.enums.TipoChavePix;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_CHAVE_PIX")
public class ChavePix {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

	@Column(name = "TIPO_CHAVE_PIX")
	@Enumerated(value = EnumType.STRING)
	private TipoChavePix tipoChavePix;

	@Column(name = "VALOR_CHAVE_PIX")
	private String valorChavePix;

	@Column(name = "ATIVO")
	private boolean ativo;


	public ChavePix() {
	}

	public ChavePix(Conta conta, TipoChavePix tipoChavePix, String valorChavePix, boolean ativo) {
		this.conta = conta;
		this.tipoChavePix = tipoChavePix;
		this.valorChavePix = valorChavePix;
		this.ativo = ativo;
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

	public TipoChavePix getTipoChavePix() {
		return tipoChavePix;
	}

	public void setTipoChavePix(TipoChavePix tipoChavePix) {
		this.tipoChavePix = tipoChavePix;
	}

	public String getValorChavePix() {
		return valorChavePix;
	}

	public void setValorChavePix(String valorChavePix) {
		this.valorChavePix = valorChavePix;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
