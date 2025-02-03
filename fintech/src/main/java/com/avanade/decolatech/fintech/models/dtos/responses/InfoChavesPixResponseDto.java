package com.avanade.decolatech.fintech.models.dtos.responses;

public class InfoChavesPixResponseDto {
    private String cpf;
    private String telefone;
    private String email;

    public InfoChavesPixResponseDto(String cpf, String telefone, String email) {
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.setEmail(email);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
