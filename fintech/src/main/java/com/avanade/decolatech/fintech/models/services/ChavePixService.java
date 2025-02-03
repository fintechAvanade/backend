package com.avanade.decolatech.fintech.models.services;

import java.util.List;
import java.util.UUID;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarChavePixRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.InfoChavesPixResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.enums.TipoChavePix;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.repositories.ChavePixRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ChavePixService {
	
	@Autowired
	private ChavePixRepository chavePixRepository;

	@Autowired
	private ContaService contaService;

	public InfoChavesPixResponseDto buscarInformacoesParaCadastro(int idConta) {
		var conta = contaService.buscarContaPeloId(idConta);
		return new InfoChavesPixResponseDto(
				conta.getUsuario().getCpf(),
				conta.getUsuario().getTelefone(),
				conta.getUsuario().getEmail()
		);
	}

	public List<ChavePix> buscarTodasChavesPixPelaConta(Conta conta){
		return chavePixRepository.findAllByConta(conta);
	}

	public List<ChavePixResponseDto> buscarChavePixPeloIdConta(int idConta){
		return chavePixRepository.buscarChavePixPelaidConta(idConta);
	}

	public void salvarChavesPix(List<ChavePix> chavePixList){
		chavePixRepository.saveAll(chavePixList);
	}

	public ChavePixResponseDto criarNovaChavePix(int idConta,CriarChavePixRequestDto request) {
		var tipoChave = TipoChavePix.valueOf(request.getTipoChave().toUpperCase());

		var conta = contaService.buscarContaPeloId(idConta);

		var valor = "";

		switch (tipoChave) {
			case CPF:
				valor = conta.getUsuario().getCpf();
				break;
			case EMAIL:
				valor = conta.getUsuario().getEmail();
				break;
			case TELEFONE:
				valor = conta.getUsuario().getTelefone();
				break;
			case CODIGO_ALEATORIO:
				UUID uuid = UUID.randomUUID();
				valor = uuid.toString().replace("-", "").substring(0, 32);
				break;
			default:
				throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		var chavesCadastradas = buscarTodasChavesPixPelaConta(conta);

		for (int i = 0; i < chavesCadastradas.size(); i++) {
			if(chavesCadastradas.get(i).getValorChavePix().equals(valor)){
				if (!chavesCadastradas.get(i).isAtivo()){
					var chaveAtiva = chavesCadastradas.get(i);
					chaveAtiva.setAtivo(true);
					chavePixRepository.save(chaveAtiva);
				}

				return new ChavePixResponseDto(
						chavesCadastradas.get(i).getId(),
						chavesCadastradas.get(i).getTipoChavePix().toString(),
						chavesCadastradas.get(i).getValorChavePix());
			}

		}

		var chavePix = chavePixRepository.save(new ChavePix(conta, tipoChave, valor, true));

		return new ChavePixResponseDto(chavePix.getId(), chavePix.getTipoChavePix().toString(), chavePix.getValorChavePix());
	}


	public String desativarChavePix(int idChave) {
		var chave = chavePixRepository.getReferenceById(idChave);
		chave.setAtivo(false);

		chavePixRepository.save(chave);

		return "Chave pix desativada";
	}

	public ChavePix buscarChavePix(String codigo) {
		return chavePixRepository.findByValorChavePix(codigo);
	}
}
