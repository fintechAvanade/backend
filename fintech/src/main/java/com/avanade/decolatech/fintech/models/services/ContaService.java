package com.avanade.decolatech.fintech.models.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.avanade.decolatech.fintech.models.dtos.requests.ValorRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.Direcao;
import com.avanade.decolatech.fintech.models.enums.StatusMovimentacao;
import com.avanade.decolatech.fintech.models.enums.TipoMovimentacao;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta buscarContaPeloId(int idConta){
        return contaRepository.getReferenceById(idConta);
    }

    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    public Conta buscarContaPeloUsuario(Usuario usuario){
        var contaDb = contaRepository.findByUsuario(usuario);

        if(contaDb.isEmpty()) throw new RuntimeException("Conta não encontrada");

        return contaDb.get();
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

    public Conta salvarConta(Conta conta){
        return contaRepository.save(conta);
    }
    
    public List<InfoContasResponseDto> listarContasGerenciamento(){
    	return contaRepository.listarContasClienteGerenciamento();
    }
}