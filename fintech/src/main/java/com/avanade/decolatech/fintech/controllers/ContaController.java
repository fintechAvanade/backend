package com.avanade.decolatech.fintech.controllers;

import java.util.List;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.decolatech.fintech.models.dtos.responses.AdminContasClienteDTO;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Conta>> listar(){
        return new ResponseEntity<List<Conta>>(contaService.listarContas(), HttpStatus.OK);
    }

    @GetMapping("{id}/saldo")
    public ResponseEntity<ValorResponseDto> obterSaldoAtual(@PathVariable("id") int idConta){
        return new ResponseEntity<ValorResponseDto>(contaService.obterSaldoAtual(idConta), HttpStatus.OK);
    }

    @GetMapping("{id}/entradas")
    public ResponseEntity<Double> obterEntradas(@PathVariable("id") int idConta){
        return new ResponseEntity<Double>(contaService.obterEntradas(idConta), HttpStatus.OK);
    }

    @GetMapping("{id}/saidas")
    public ResponseEntity<Double> obterSaidas(@PathVariable("id") int idConta){
        return new ResponseEntity<Double>(contaService.obterEntradas(idConta), HttpStatus.OK);
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
