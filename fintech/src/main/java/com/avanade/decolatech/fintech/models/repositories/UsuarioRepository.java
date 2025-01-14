package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
