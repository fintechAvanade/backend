package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioService.listarUsuarios();
    }
}
