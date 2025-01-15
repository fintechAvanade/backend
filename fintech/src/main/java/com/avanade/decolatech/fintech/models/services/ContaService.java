package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public Conta incluirConta(Conta conta){
        return contaRepository.save(conta);
    }
}
