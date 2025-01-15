package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.entities.Cartao;
import com.avanade.decolatech.fintech.models.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public List<Cartao> listarCartao(){
        return cartaoRepository.findAll();
    }

    public Cartao incluirCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }
}
