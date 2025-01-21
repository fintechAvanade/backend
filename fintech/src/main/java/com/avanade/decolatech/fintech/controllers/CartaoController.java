package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.responses.CartaoResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.services.CartaoService;
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
    private CartaoService cartaoService;

    @GetMapping("conta/{id}")
    public ResponseEntity<CartaoResponseDto> obterCartaoPeloIdConta(@PathVariable("id") int idConta){
        return new ResponseEntity<CartaoResponseDto>(cartaoService.buscarCartaoPeloIdConta(idConta), HttpStatus.OK);
    }


}
