package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = """
    SELECT\s
        u.id AS id,
        u.nome AS nome,
        u.usuario AS nomeUsuario,
        u.cpf AS cpf,
        u.DATA_NASCIMENTO AS dataNascimento,
        u.email AS email,
        u.telefone AS telefone
    FROM TB_USUARIO u\s
    WHERE u.id = :idUsuario
   \s""", nativeQuery = true)
    UsuarioResponseDto buscarUsuarioPeloId(@Param("idUsuario") int idUsuario);

   @Query(value = "SELECT * FROM TB_USUARIO U WHERE U.USUARIO = :username", nativeQuery = true)
    Usuario getUserByUsername(@Param("username") String username);


    Optional<Usuario> findByNomeUsuario(String username);
}
