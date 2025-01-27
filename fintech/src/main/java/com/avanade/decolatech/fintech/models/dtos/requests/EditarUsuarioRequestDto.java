package com.avanade.decolatech.fintech.models.dtos.requests;

import java.util.Date;

public class EditarUsuarioRequestDto {
    private String nome;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String nomeUsuario;
    private String senha;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String estado;
    private int numero;
    private String complemento;
    private String tipoConta;

    public EditarUsuarioRequestDto() {
    }

    public EditarUsuarioRequestDto(String nome, Date dataNascimento, String email, String telefone, String nomeUsuario, String senha, String cep, String cidade, String bairro, String logradouro, String estado, int numero, String complemento, String tipoConta) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setNomeUsuario(nomeUsuario);
        this.setSenha(senha);
        this.setCep(cep);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setLogradouro(logradouro);
        this.setEstado(estado);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setTipoConta(tipoConta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
