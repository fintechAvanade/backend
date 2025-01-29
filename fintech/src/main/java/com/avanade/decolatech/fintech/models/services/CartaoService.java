package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.responses.CartaoResponseDto;
import com.avanade.decolatech.fintech.models.entities.Cartao;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.repositories.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public List<Cartao> buscarCartaoPelaConta(Conta conta){
        return cartaoRepository.findAllByConta(conta);
    }

    public List<CartaoResponseDto> buscarCartoesPeloIdUsuario(int idUsuario){
        return cartaoRepository.buscarCartaoPeloIdUsuario(idUsuario);
    }

    public Cartao salvarCartao(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public void salvarCartoes(List<Cartao> cartoes){
        cartaoRepository.saveAll(cartoes);
    }

    public Cartao criarCartao(Conta conta){
        var random = new Random();

        var cartao = new Cartao();
        cartao.setNumeroCartao(String.valueOf(1_000_000_000_000_000L+random.nextLong(9_000_000_000_000_000L)));
        cartao.setCvv(String.valueOf(100+random.nextInt(900)));
        cartao.setDataValidadeCartao(Date.from(LocalDate.now().plusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        cartao.setConta(conta);
        cartao.setAtivo(true);
        return salvarCartao(cartao);
    }
}
