package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
