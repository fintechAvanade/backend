package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoConta;

import java.util.Date;

public class UsuarioResponseDto {
    private String nome;
    private String nomeUsuario;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private EnderecoResponseDto endereco;
    private ContaResponseDto conta;

    public UsuarioResponseDto(
            String nome,
            String nomeUsuario,
            String cpf,
            Date dataNascimento,
            String email,
            String telefone,
            String cep,
            String cidade,
            String bairro,
            String logradouro,
            String estado,
            String numero,
            String complemento,
            int agencia,
            int numeroConta,
            TipoConta tipoConta
    ) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = new EnderecoResponseDto(cep, cidade, bairro, logradouro, estado, numero, complemento);
        this.conta = new ContaResponseDto(agencia, numeroConta, tipoConta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public EnderecoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponseDto endereco) {
        this.endereco = endereco;
    }

    public ContaResponseDto getConta() {
        return conta;
    }

    public void setConta(ContaResponseDto conta) {
        this.conta = conta;
    }
}