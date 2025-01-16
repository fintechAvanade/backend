package com.avanade.decolatech.fintech.models.services;


import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import com.avanade.decolatech.fintech.models.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoServices {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }
    public Movimentacao incluirMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

}
