package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.dtos.responses.EditarClienteResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = """
    SELECT
        u.id AS id,
        u.nome AS nome,
        u.usuario AS nomeUsuario,
        u.cpf AS cpf,
        u.DATA_NASCIMENTO AS dataNascimento,
        u.email AS email,
        u.telefone AS telefone
    FROM TB_USUARIO u
    WHERE u.id = :idUsuario""", nativeQuery = true)
    UsuarioResponseDto buscarUsuarioPeloId(@Param("idUsuario") int idUsuario);

   @Query(value = "SELECT * FROM TB_USUARIO U WHERE U.USUARIO = :username", nativeQuery = true)
    Usuario getUserByUsername(@Param("username") String username);

   @Query(value = """
           SELECT
               c.ID AS idConta,
               U.ID AS idUsuario,
               U.NOME AS nome,
               U.USUARIO AS nomeUsuario,
               U.CPF AS cpf,
               U.DATA_NASCIMENTO AS dataNascimento,
               U.EMAIL AS email,
               U.TELEFONE AS telefone,
               E.CEP AS cep,
               E.CIDADE AS cidade,
               E.BAIRRO AS bairro,
               E.LOGRADOURO AS logradouro,
               E.ESTADO AS estado,
               E.NUMERO AS numero,
               E.COMPLEMENTO AS complemento,
               U.ATIVO AS ativo
           FROM TB_USUARIO U
           INNER JOIN TB_ENDERECO E ON U.ID_ENDERECO = E.ID
           INNER JOIN TB_CONTA C ON U.ID = C.ID_USUARIO
           WHERE U.ID = :idUsuario
           """, nativeQuery = true)
    EditarClienteResponseDto buscarUsuarioEnderecoPorId(@Param("idUsuario") int idUsuario);


    Usuario findByNomeUsuario(String username);
}
