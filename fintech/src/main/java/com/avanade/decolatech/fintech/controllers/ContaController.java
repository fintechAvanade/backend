package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.responses.ContaResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping("/{id}")
    public ResponseEntity<ContaResponseDto> obterConta(@PathVariable("id") int idConta){
        return new ResponseEntity<ContaResponseDto>(contaService.buscarContaResponse(idConta), HttpStatus.OK);
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
        return new ResponseEntity<ValorResponseDto>(contaService.obterSaidas(idConta), HttpStatus.OK);
    }
}
