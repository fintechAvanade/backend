package com.avanade.decolatech.fintech.models.entities;

import java.util.Date;
import java.util.List;

import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Conta> conta;
}
