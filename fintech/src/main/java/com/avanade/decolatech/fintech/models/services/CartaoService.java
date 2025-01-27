package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.responses.CartaoResponseDto;
import com.avanade.decolatech.fintech.models.entities.Cartao;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public List<Cartao> buscarCartaoPelaConta(Conta conta){
        return cartaoRepository.findAllByConta(conta);
    }

    public CartaoResponseDto buscarCartaoPeloIdConta(int idConta){
        return cartaoRepository.buscarCartaoPeloIdConta(idConta);
    }

    public Cartao salvarCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public void salvarCartoes(List<Cartao> cartoes){
        cartaoRepository.saveAll(cartoes);
    }
}
