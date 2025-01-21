package com.avanade.decolatech.fintech.models.entities;

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
@Table(name = "TB_CHAVE_PIX")
public class ChavePix {

	    @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "ID_CONTA")
	    private Conta conta;

	    private int tipoChavePix;
	    private int valorChavePix;
	    private boolean ativo;
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
		public int getTipoChavePix() {
			return tipoChavePix;
		}
		public void setTipoChavePix(int tipoChavePix) {
			this.tipoChavePix = tipoChavePix;
		}
		public int getValorChavePix() {
			return valorChavePix;
		}
		public void setValorChavePix(int valorChavePix) {
			this.valorChavePix = valorChavePix;
		}
		public boolean isAtivo() {
			return ativo;
		}
		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}

	    
	}
