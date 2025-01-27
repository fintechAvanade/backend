package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDto> obterUsuarioPorId(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<UsuarioResponseDto>(service.buscarUsuarioPorId(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<LoginResponseDto> cadastrarUsuario(@RequestBody CriarUsuarioRequestDto request){
        return new ResponseEntity<LoginResponseDto>(service.cadastrarUsuario(request), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{idUsuario}")
    public ResponseEntity<String> editarUsuario(@PathVariable("idUsuario") int idUsuario, @RequestBody EditarUsuarioRequestDto request){
        return new ResponseEntity<String>(service.editarUsuario(idUsuario, request), HttpStatus.ACCEPTED);
    }

    @PutMapping("/desativar/{idUsuario}")
    public ResponseEntity<String> desativarUsuario(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<String>(service.alterarEstadoUsuario(idUsuario, false), HttpStatus.ACCEPTED);
    }

    @PutMapping("/ativar/{idUsuario}")
    public ResponseEntity<String> ativarUsuario(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<String>(service.alterarEstadoUsuario(idUsuario, true), HttpStatus.ACCEPTED);
    }

}
