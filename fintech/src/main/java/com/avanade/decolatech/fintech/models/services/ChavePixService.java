package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.repositories.ChavePixRepository;

@Service
public class ChavePixService {
	
	@Autowired
	private ChavePixRepository chavePixRepository;
	
	public List<ChavePix> findAll() {
		return chavePixRepository.findAll();
	}

	public List<ChavePixResponseDto> buscarChavePixPeloIdConta(int idConta){
		return chavePixRepository.buscarChavePixPelaidConta(idConta);
	}
	
	public ChavePix findById (int id) {
		return chavePixRepository.findById(id).orElse(null);
	}
	
	public ChavePix save(ChavePix chavePix) {
		return chavePixRepository.save(chavePix);
	}
	
	public void deleteBId (int id) {
		chavePixRepository.deleteById(id);
	}
	
	
}
