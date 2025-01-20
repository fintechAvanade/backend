package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDto> obterUsuarioPorId(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<UsuarioResponseDto>(usuarioService.obterUsuarioPorId(idUsuario), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> lista(){
        return new ResponseEntity<List<Usuario>>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<Usuario>(usuarioService.incluirUsuario(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
