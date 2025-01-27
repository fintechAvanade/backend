package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.repositories.ChavePixRepository;

@Service
public class ChavePixService {
	
	@Autowired
	private ChavePixRepository chavePixRepository;

	public List<ChavePix> buscarTodasChavesPixPelaConta(Conta conta){
		return chavePixRepository.findAllByConta(conta);
	}

	public List<ChavePixResponseDto> buscarChavePixPeloIdConta(int idConta){
		return chavePixRepository.buscarChavePixPelaidConta(idConta);
	}
	
	public ChavePix salvarChavePix(ChavePix chavePix) {
		return chavePixRepository.save(chavePix);
	}

	public void salvarChavesPix(List<ChavePix> chavePixList){
		chavePixRepository.saveAll(chavePixList);
	}

}
