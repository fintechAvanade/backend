package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
