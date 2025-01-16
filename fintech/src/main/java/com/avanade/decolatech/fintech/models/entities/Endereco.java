package com.avanade.decolatech.fintech.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_ENDERECO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "endereco")
	private List<Usuario> usuarios;
}
