package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
}
