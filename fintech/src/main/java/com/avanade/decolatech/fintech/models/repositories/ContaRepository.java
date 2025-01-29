package com.avanade.decolatech.fintech.models.repositories;

import java.util.List;
import java.util.Optional;

import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.data.repository.query.Param;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Conta findByAgenciaAndNumeroConta(String agencia, String numeroConta);

    Optional<Conta> findByUsuario(Usuario usuario);

    @Query(value = """
            SELECT
            	C.ID AS id,
                C.AGENCIA AS agencia,
                C.NUMERO_CONTA AS numeroConta,
            	U.NOME AS nome,
                M.DATA_HORA AS ultimaMovimentacao,
                U.DATA_ULTIMO_ACESSO AS ultimoAcesso,
                C.ATIVO AS ativo
            FROM\s
                TB_USUARIO U
                INNER JOIN TB_CONTA C ON U.ID = C.ID_USUARIO
                INNER JOIN TB_MOVIMENTACAO M ON C.ID = M.ID_CONTA
            WHERE\s
                M.DATA_HORA = (SELECT MAX(DATA_HORA) FROM TB_MOVIMENTACAO WHERE ID_CONTA = C.ID)
            """, nativeQuery = true)
    List<InfoContasResponseDto> listarContas();

    @Query(value = "SELECT C.SALDO AS [valor] FROM TB_CONTA C WHERE C.ID = :id", nativeQuery = true)
    ValorResponseDto obterSaldo(@Param("id") int id);

    @Query(value = "SELECT ISNULL(SUM(VALOR_MOVIMENTACAO), 0) AS [valor] FROM TB_MOVIMENTACAO M WHERE M.DIRECAO = 'D' AND M.ID_CONTA = :id", nativeQuery = true)
    ValorResponseDto obterEntradas(@Param("id") int id);

    @Query(value = "SELECT ISNULL(SUM(VALOR_MOVIMENTACAO), 0) AS [valor] FROM TB_MOVIMENTACAO M WHERE M.DIRECAO = 'C' AND M.ID_CONTA = :id", nativeQuery = true)
    ValorResponseDto obterSaidas(@Param("id") int id);
}