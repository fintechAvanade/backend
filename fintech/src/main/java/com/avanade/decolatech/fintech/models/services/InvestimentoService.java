package com.avanade.decolatech.fintech.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.avanade.decolatech.fintech.models.entities.Investimento;
import com.avanade.decolatech.fintech.models.repositories.InvestimentoRepository;

public class InvestimentoService {
	
	@Autowired
	private InvestimentoRepository investimentoRepository;
	
	public List<Investimento> listarInvestimentos(){
		return investimentoRepository.findAll();
	}
	
	public Investimento incluirInvestimento(Investimento investimento) {
		return investimentoRepository.save(investimento);
	}
	
	public void apagarInvestimento(Investimento investimento) {
		investimentoRepository.delete(investimento);
	}
}
