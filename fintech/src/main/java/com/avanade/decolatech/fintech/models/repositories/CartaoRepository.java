package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.dtos.responses.CartaoResponseDto;
import com.avanade.decolatech.fintech.models.entities.Cartao;
import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    List<Cartao> findAllByConta(Conta conta);

    @Query(value = """
            SELECT\s
                C1.NUMERO_CARTAO AS numeroCartao,
                U.NOME AS titular,
                C1.VALIDADE_CARTAO AS dataExpiracao,
                C1.CVV AS cvv
            FROM TB_CARTAO C1\s
            INNER JOIN TB_CONTA AS C2 ON C1.ID_CONTA = C2.ID
            INNER JOIN TB_USUARIO U ON C2.ID_USUARIO = U.ID
            WHERE C1.ATIVO = 1 AND U.ID = :idUsuario
            """, nativeQuery = true)
    List<CartaoResponseDto> buscarCartaoPeloIdUsuario(@Param("idUsuario") int idUsuario);
}
