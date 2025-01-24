package com.avanade.decolatech.fintech.models.dtos.responses;

import com.avanade.decolatech.fintech.models.enums.TipoChavePix;

public class ChavePixResponseDto {
    private int id;
    private String tipoChavePix;
    private String chave;

    public ChavePixResponseDto() {
    }

    public ChavePixResponseDto(int id, String tipoChavePix, String chave) {
        this.setId(id);
        this.setTipoChavePix(tipoChavePix);
        this.setChave(chave);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
