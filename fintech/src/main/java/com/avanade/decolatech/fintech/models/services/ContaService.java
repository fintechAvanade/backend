package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.dto.response.AdminContasClienteDTO;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public Conta incluirConta(Conta conta){
        return contaRepository.save(conta);
    }
    
    public List<AdminContasClienteDTO> listarContasGerenciamento(){
    	return contaRepository.listarContasClienteGerenciamento();
    }
}
