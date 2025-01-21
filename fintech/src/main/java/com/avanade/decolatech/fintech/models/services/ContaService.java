package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public ValorResponseDto obterSaldoAtual(int id){
        return contaRepository.obterSaldo(id);
    }

    public ValorResponseDto obterEntradas(int id){
        return contaRepository.obterEntradas(id);
    }

    public  ValorResponseDto obterSaidas(int id){
        return contaRepository.obterSaidas(id);
    }

    public Conta incluirConta(Conta conta){
        return contaRepository.save(conta);
    }
    
    public List<InfoContasResponseDto> listarContasGerenciamento(){
    	return contaRepository.listarContasClienteGerenciamento();
    }
}
