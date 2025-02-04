package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.dtos.responses.MovimentacoesResponseDto;
import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    @Query(value = """
            SELECT M.TIPO_MOVIMENTACAO, M.DATA_HORA, M.VALOR_TOTAL, M.DIRECAO 
            FROM TB_MOVIMENTACAO M WHERE M.ID_CONTA = :idConta
            ORDER BY M.DATA_HORA DESC
            """,
            nativeQuery = true)
    List<MovimentacoesResponseDto> listarMovimentacoesPorIdConta(@Param("idConta") int idConta);

    @Query(
            value ="""
            SELECT M.TIPO_MOVIMENTACAO, M.DATA_HORA, M.VALOR_TOTAL, M.DIRECAO
            FROM TB_MOVIMENTACAO M
            WHERE M.DIRECAO = 'CREDITO' AND M.ID_CONTA = :idConta
            ORDER BY M.DATA_HORA DESC
            """, nativeQuery = true
    )
    List<MovimentacoesResponseDto> listarMovimentacoesCreditadasPorIdConta(@Param("idConta") int idConta);

    @Query(
            value = """
            SELECT M.TIPO_MOVIMENTACAO, M.DATA_HORA, M.VALOR_TOTAL, M.DIRECAO
            FROM TB_MOVIMENTACAO M
            WHERE M.DIRECAO = 'DEBITO' AND M.ID_CONTA = :idConta
            ORDER BY M.DATA_HORA DESC
            """, nativeQuery = true
    )
    List<MovimentacoesResponseDto> listarMovimentacoesDebitadasPorIdConta(@Param("idConta") int idConta);

}
