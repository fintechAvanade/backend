package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoChavePix;

public class ChavePixResponseDto {
    private String tipoChavePix;
    private String chave;

    public ChavePixResponseDto() {
    }

    public ChavePixResponseDto(String tipoChavePix, String chave) {
        this.setTipoChavePix(tipoChavePix);
        this.setChave(chave);
    }

    public String getTipoChavePix() {
        return tipoChavePix;
    }

    public void setTipoChavePix(String tipoChavePix) {
        this.tipoChavePix = tipoChavePix;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
