package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.responses.CartaoResponseDto;
import com.avanade.decolatech.fintech.models.services.CartaoService;
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

    @GetMapping("usuario/{idUsuario}")
    public ResponseEntity<List<CartaoResponseDto>> buscarCartaoPeloIdUsuario(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<List<CartaoResponseDto>>(cartaoService.buscarCartoesPeloIdUsuario(idUsuario), HttpStatus.OK);
    }
}
