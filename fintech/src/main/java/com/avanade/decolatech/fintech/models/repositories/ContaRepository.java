package com.avanade.decolatech.fintech.models.repositories;

import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
