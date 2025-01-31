package com.avanade.decolatech.fintech.models.dtos.requests;

public class CriarChavePixRequestDto {
    private String tipoChave;

    public CriarChavePixRequestDto(String tipoChave) {
        this.setTipoChave(tipoChave);
    }

    public String getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(String tipoChave) {
        this.tipoChave = tipoChave;
    }
}
