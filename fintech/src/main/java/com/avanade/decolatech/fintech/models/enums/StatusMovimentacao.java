package com.avanade.decolatech.fintech.models.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_STATUS_MOVIMENTACAO")
public enum StatusMovimentacao {
	SUCESSO,
	ERRO,
	PENDENTE
}
