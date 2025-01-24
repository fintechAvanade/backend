package com.avanade.decolatech.fintech.models.dtos.requests;

public class LoginAdminRequestDto {
    private String usuario;
    private String senha;

    public LoginAdminRequestDto() {
    }

    public LoginAdminRequestDto(String usuario, String senha) {
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
