package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.repositories.ChavePixRepository;

@Service
public class ChavePixService {
	
	@Autowired
	private ChavePixRepository repository;
	
	public List<ChavePix> findAll() {
		return repository.findAll();
	}
	
	public ChavePix findById (int id) {
		return repository.findById(id).orElse(null);
	}
	
	public ChavePix save(ChavePix chavePix) {
		return repository.save(chavePix);
	}
	
	public void deleteBId (int id) {
		repository.deleteById(id);
	}
	
	
}
