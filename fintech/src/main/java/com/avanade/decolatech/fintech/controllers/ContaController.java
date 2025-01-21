package com.avanade.decolatech.fintech.controllers;

import java.util.List;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;

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
    public ResponseEntity<ValorResponseDto> obterEntradas(@PathVariable("id") int idConta){
        return new ResponseEntity<ValorResponseDto>(contaService.obterEntradas(idConta), HttpStatus.OK);
    }

    @GetMapping("{id}/saidas")
    public ResponseEntity<ValorResponseDto> obterSaidas(@PathVariable("id") int idConta){
        return new ResponseEntity<ValorResponseDto>(contaService.obterEntradas(idConta), HttpStatus.OK);
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
    public ResponseEntity<List<InfoContasResponseDto>> listarClientes(){
    	return new ResponseEntity<List<InfoContasResponseDto>>(contaService.listarContasGerenciamento(), HttpStatus.OK);
    }
}
