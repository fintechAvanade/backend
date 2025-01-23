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
        u.nome AS nome,
        u.usuario AS nomeUsuario,
        u.cpf AS cpf,
        u.DATA_NASCIMENTO AS dataNascimento,
        u.email AS email,
        u.telefone AS telefone,
        e.cep AS cep,
        e.cidade AS cidade,
        e.bairro AS bairro,
        e.logradouro AS logradouro,
        e.estado AS estado,
        e.numero AS numero,
        e.complemento AS complemento,
        c.agencia AS agencia,
        c.NUMERO_CONTA AS numeroConta,
        c.TIPO_CONTA AS tipoConta
    FROM TB_USUARIO u\s
    INNER JOIN TB_ENDERECO e ON u.ID_ENDERECO = e.ID\s
    INNER JOIN TB_CONTA c ON c.ID_USUARIO = u.ID
    WHERE u.id = :idUsuario
   \s""", nativeQuery = true)
    UsuarioResponseDto listarUsuarioPeloId(@Param("idUsuario") int idUsuario);

    Optional<Usuario> findByNomeUsuario(String username);
}
