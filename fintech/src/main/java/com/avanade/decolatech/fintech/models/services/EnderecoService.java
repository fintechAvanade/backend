package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco incluirEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

}
