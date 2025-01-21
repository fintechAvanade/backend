package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private ChavePixService service;
	
	@GetMapping
	public List<ChavePix> findAll() {
		return service.findAll();	
	}

	@GetMapping("/{id}")
	public ChavePix findById (@PathVariable int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ChavePix save(@RequestBody ChavePix chavePix) {
		return service.save(chavePix);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById (@PathVariable int id) {
		service.deleteBId(id);
	}
	
}
