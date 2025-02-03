package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarChavePixRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.InfoChavesPixResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.MensagemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.decolatech.fintech.models.services.ChavePixService;

@RestController
@RequestMapping("/chavePix")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class ChavePixController {
	
	@Autowired
	private ChavePixService chavePixService;

	@GetMapping("/buscar-informacoes/{idConta}")
	public ResponseEntity<InfoChavesPixResponseDto> buscarInformacoes(@PathVariable("idConta") int idConta){
		return new ResponseEntity<InfoChavesPixResponseDto>(chavePixService.buscarInformacoesParaCadastro(idConta), HttpStatus.OK);
	}

	@GetMapping("/listar/{idConta}")
	public ResponseEntity<List<ChavePixResponseDto>> buscarChavesPelaidConta(@PathVariable("idConta") int idConta){
		return new ResponseEntity<List<ChavePixResponseDto>>(chavePixService.buscarChavePixPeloIdConta(idConta), HttpStatus.OK);
	}

	@PostMapping("/novo/{idConta}")
	public ResponseEntity<ChavePixResponseDto> cadastrar(@PathVariable("idConta") int idConta, @RequestBody CriarChavePixRequestDto request){
		return new ResponseEntity<ChavePixResponseDto>(chavePixService.criarNovaChavePix(idConta, request), HttpStatus.CREATED);
	}

	@PutMapping("/desativar/{idChave}")
	public ResponseEntity<MensagemResponseDto> desativarChave(@PathVariable("idChave") int idChave){
		var response = chavePixService.desativarChavePix(idChave);
		var mensagem = new MensagemResponseDto(response);
		return new ResponseEntity<MensagemResponseDto>(mensagem, HttpStatus.ACCEPTED);
	}

}