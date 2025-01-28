package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Endereco>> lista(){
        return new ResponseEntity<List<Endereco>>(enderecoService.listarEnderecos(), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> cadastrar(@RequestBody Endereco endereco){
        try {
            return new ResponseEntity<Endereco>(enderecoService.salvarEndereco(endereco), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
