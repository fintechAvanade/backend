package com.avanade.decolatech.fintech.models.dtos.responses;

import java.util.Date;

public class EditarClienteResponseDto {
    private int idConta;
    private int idUsuario;
    private String nome;
    private String nomeUsuario;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String estado;
    private int numero;
    private String complemento;
    private boolean ativo;
    private String tipoConta;

    public EditarClienteResponseDto() {
    }

    public EditarClienteResponseDto(
            int idConta,
            int idUsuario,
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
            int numero,
            String complemento,
            boolean ativo,
            String tipoConta
    ) {
        this.setIdConta(idConta);
        this.setIdUsuario(idUsuario);
        this.setNome(nome);
        this.setNomeUsuario(nomeUsuario);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setCep(cep);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setLogradouro(logradouro);
        this.setBairro(bairro);
        this.setEstado(estado);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setAtivo(ativo);
        this.setTipoConta(tipoConta);
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
