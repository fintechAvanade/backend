package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.services.ChavePixService;

@RestController
@RequestMapping("/chavePix")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class ChavePixController {
	
	@Autowired
	private ChavePixService chavePixService;

	@GetMapping("lista/conta/{id}")
	public ResponseEntity<List<ChavePixResponseDto>> buscarChavesPelaidConta(@PathVariable("id") int idConta){
		return new ResponseEntity<List<ChavePixResponseDto>>(chavePixService.buscarChavePixPeloIdConta(idConta), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ChavePix cadastrar(@RequestBody ChavePix chavePix) {
		return chavePixService.salvarChavePix(chavePix);
	}
}