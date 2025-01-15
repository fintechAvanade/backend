package com.avanade.decolatech.fintech.models.entities;

import java.util.Date;
import java.util.List;

import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

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
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Column(name = "NUMERO_TENTATIVAS_ACESSO")
	private int numerosTentativasAcesso;
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Conta> conta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getNumerosTentativasAcesso() {
		return numerosTentativasAcesso;
	}

	public void setNumerosTentativasAcesso(int numerosTentativasAcesso) {
		this.numerosTentativasAcesso = numerosTentativasAcesso;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}

	
}
