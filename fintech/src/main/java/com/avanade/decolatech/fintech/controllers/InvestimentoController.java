package com.avanade.decolatech.fintech.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.decolatech.fintech.models.entities.Investimento;
import com.avanade.decolatech.fintech.models.services.InvestimentoService;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

	@Autowired
    private InvestimentoService investimentoService;
	

    @GetMapping("/lista")
    public ResponseEntity<List<Investimento>> lista(){
        return new ResponseEntity<List<Investimento>>(investimentoService.listarInvestimentos(), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Investimento investimento){
        try {
            return new ResponseEntity<Investimento>(investimentoService.incluirInvestimento(investimento), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    

    // Não copiar essa parte
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizar(@RequestBody Investimento investimento){
        try{
            return  new ResponseEntity<Investimento>(investimentoService.incluirInvestimento(investimento), HttpStatus.OK);
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/apagar")
    public ResponseEntity<?> apagar(@RequestBody Investimento investimento){
        try{
        	investimentoService.apagarInvestimento(investimento);
            return new ResponseEntity<String>("Endereço apagado com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}











