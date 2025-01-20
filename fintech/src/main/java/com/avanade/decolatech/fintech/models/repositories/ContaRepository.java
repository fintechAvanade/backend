package com.avanade.decolatech.fintech.models.repositories;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avanade.decolatech.fintech.models.dtos.responses.AdminContasClienteDTO;
import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.data.repository.query.Param;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query(value = "\r\n"
            + "SELECT\r\n"
            + "	C.ID,\r\n"
            + "    C.AGENCIA,\r\n"
            + "    C.NUMERO_CONTA,\r\n"
            + "	U.NOME,\r\n"
            + "    M.DATA_HORA as [ULTIMA MOVIMENTACAO],\r\n"
            + "    U.DATA_ULTIMO_ACESSO as [ULTIMO ACESSO],\r\n"
            + "    C.ATIVO\r\n"
            + "FROM \r\n"
            + "    TB_USUARIO U\r\n"
            + "    INNER JOIN TB_CONTA C ON U.ID = C.ID_USUARIO\r\n"
            + "    INNER JOIN TB_MOVIMENTACAO M ON C.ID = M.ID_CONTA\r\n"
            + "WHERE \r\n"
            + "    M.DATA_HORA = (SELECT MAX(DATA_HORA) FROM TB_MOVIMENTACAO\r\n"
            + "						WHERE ID_CONTA = C.ID);", nativeQuery = true)
    List<AdminContasClienteDTO> listarContasClienteGerenciamento();

    @Query(value = "SELECT C.SALDO AS [valor] FROM TB_CONTA C WHERE C.ID = :id", nativeQuery = true)
    ValorResponseDto obterSaldo(@Param("id") int id);

    @Query(value = "SELECT ISNULL(SUM(VALOR_MOVIMENTACAO), 0) AS [valor] FROM TB_MOVIMENTACAO M WHERE M.DIRECAO = 'D' AND M.ID_CONTA = :id", nativeQuery = true)
    double obterEntradas(@Param("id") int id);

    @Query(value = "SELECT ISNULL(SUM(VALOR_MOVIMENTACAO), 0) AS [valor] FROM TB_MOVIMENTACAO M WHERE M.DIRECAO = 'C' AND M.ID_CONTA = :id", nativeQuery = true)
    double obterSaidas(@Param("id") int id);
}