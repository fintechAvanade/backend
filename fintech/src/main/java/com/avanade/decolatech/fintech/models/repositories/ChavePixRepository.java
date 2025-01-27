package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChavePixRepository extends JpaRepository<ChavePix, Integer> {

    List<ChavePix> findAllByConta(Conta conta);

    @Query(value = """
            SELECT\s
                CP.ID AS id,\s
                CP.TIPO_CHAVE_PIX AS tipoChavePix,\s
                CP.VALOR_CHAVE_PIX AS chave\s
            FROM TB_CHAVE_PIX CP\s
            WHERE ATIVO = 1 AND ID_CONTA = :idConta
            """, nativeQuery = true)
    List<ChavePixResponseDto> buscarChavePixPelaidConta(@Param("idConta") int idConta);
}
