package com.avanade.decolatech.fintech.models.services;

import java.util.List;
import java.util.Random;

import com.avanade.decolatech.fintech.models.dtos.responses.ContaResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.TipoConta;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta buscarContaPeloId(int idConta){
        return contaRepository.getReferenceById(idConta);
    }

    public ContaResponseDto buscarContaResponse(int idConta){
        return contaRepository.buscarConta(idConta);
    }

    public Conta buscarContaPelaAgenciaENumeroConta(String agencia, String numeroConta){
        return contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta);
    }

    public List<InfoContasResponseDto> listarContasAdmin(){
        return contaRepository.listarContas();
    }

    public Conta buscarContaPeloUsuario(Usuario usuario){
        var contaDb = contaRepository.findByUsuario(usuario);

        if(contaDb == null) throw new RuntimeException("Conta não encontrada");

        return contaDb;
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

    public Conta criarContaSimples(Usuario usuario){
        var random = new Random();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        var senhaPagamento = String.valueOf(100000+random.nextInt(900000));
        String hashSenhaPagamento = passwordEncoder.encode(senhaPagamento);

        var conta = new Conta();
        conta.setAgencia("0001");
        conta.setNumeroConta(String.valueOf(1_000_000_000L+random.nextLong(9_000_000_000L)));
        conta.setSaldo(0);
        conta.setHashSenhaPagamento(hashSenhaPagamento);
        conta.setAtivo(true);
        conta.setTipoConta(TipoConta.SIMPLES);
        conta.setUsuario(usuario);
        conta.setSenhaPagamento(senhaPagamento);
        return salvarConta(conta);
    }
}