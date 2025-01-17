package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.decolatech.fintech.models.dto.response.AdminContasClienteDTO;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Conta>> listar(){
        return new ResponseEntity<List<Conta>>(contaService.listarContas(), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Conta conta){
        try{
            return new ResponseEntity<Conta>(contaService.incluirConta(conta), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/clientes")
    public ResponseEntity<List<AdminContasClienteDTO>> listarClientes(){
    	return new ResponseEntity<List<AdminContasClienteDTO>>(contaService.listarContasGerenciamento(), HttpStatus.OK);
    }
}









