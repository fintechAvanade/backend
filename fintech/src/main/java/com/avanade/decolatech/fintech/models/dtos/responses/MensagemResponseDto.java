package com.avanade.decolatech.fintech.models.dtos.responses;

public class MensagemResponseDto {
    private String mensagem;

    public MensagemResponseDto() {
    }

    public MensagemResponseDto(String mensagem) {
        this.setMensagem(mensagem);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
