package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDto> obterUsuarioPorId(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<UsuarioResponseDto>(usuarioService.obterUsuarioPorId(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/novo")
    @Transactional
    public ResponseEntity<LoginResponseDto> incluirUsuario(@RequestBody CriarUsuarioRequestDto request){
        return new ResponseEntity<LoginResponseDto>(usuarioService.cadastrarUsuario(request), HttpStatus.CREATED);
    }
}
