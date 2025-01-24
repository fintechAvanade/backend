package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import com.avanade.decolatech.fintech.models.dtos.responses.ChavePixResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.decolatech.fintech.models.entities.ChavePix;
import com.avanade.decolatech.fintech.models.services.ChavePixService;

@RestController
@RequestMapping("/chavePix")
public class ChavePixController {
	
	@Autowired
	private ChavePixService chavePixService;
	
	@GetMapping("/lista")
	public List<ChavePix> lista() {
		return chavePixService.findAll();
	}

	@GetMapping("lista/conta/{id}")
	public ResponseEntity<List<ChavePixResponseDto>> buscarChavesPelaidConta(@PathVariable("id") int idConta){
		return new ResponseEntity<List<ChavePixResponseDto>>(chavePixService.buscarChavePixPeloIdConta(idConta), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ChavePix cadastrar(@RequestBody ChavePix chavePix) {
		return chavePixService.save(chavePix);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById (@PathVariable int id) {
		chavePixService.deleteBId(id);
	}
	
}
