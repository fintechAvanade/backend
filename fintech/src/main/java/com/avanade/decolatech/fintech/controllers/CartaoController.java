package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private ContaService contaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Conta>> listar(){
        return new ResponseEntity<List<Conta>>(contaService.listarContas(), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Conta conta){
        try{
            return new ResponseEntity<Conta>(contaService.incluirConta(conta), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
