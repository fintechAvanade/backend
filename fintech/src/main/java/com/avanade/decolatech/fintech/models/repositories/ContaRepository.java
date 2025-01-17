package com.avanade.decolatech.fintech.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avanade.decolatech.fintech.models.dto.response.AdminContasClienteDTO;
import com.avanade.decolatech.fintech.models.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	@Query(value ="\r\n"
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
}
