package com.avanade.decolatech.fintech.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	// testando mapeamento da classe usuario e conta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	
	@Column(name = "DATA_NASCIMENTO")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "USUARIO")
	private String nomeUsuario;
	
	@Column(name = "HASH_SENHA")
	private String hashSenha;
	
	@Column(name = "DATA_ULTIMO_ACESSO")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;
	
	@Column(name = "TIPO_USUARIO")
	private char tipoUsuario;
	
	@Column(name = "NUMERO_TENTATIVAS_ACESSO")
	private int numerosTentativasAcesso;
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA")
	private Conta conta;

}
