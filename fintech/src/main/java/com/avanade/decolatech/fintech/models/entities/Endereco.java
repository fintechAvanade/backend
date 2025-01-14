package com.avanade.decolatech.fintech.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "ENDERECO")
	private String endereco;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
}
