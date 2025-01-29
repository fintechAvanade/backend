package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarClienteRequestDto;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }


    public Endereco salvarEndereco(CriarClienteRequestDto request){
        var endereco = new Endereco();
        endereco.setCep(request.getCep());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setComplemento(request.getComplemento());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        endereco.setNumero(request.getNumero());

        return enderecoRepository.save(endereco);
    }

    public Endereco editarEndereco(EditarClienteRequestDto request, Endereco endereco){

        endereco.setCep(request.getCep());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setComplemento(request.getComplemento());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        endereco.setNumero(request.getNumero());

        return enderecoRepository.save(endereco);
    }
}
