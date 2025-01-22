package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.responses.MovimentacoesResponseDto;
import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import com.avanade.decolatech.fintech.models.services.MovimentacaoServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoServices movimentacaoServices;

    @GetMapping("lista")
    public ResponseEntity<List<Movimentacao>> lista(){
        return new ResponseEntity<List<Movimentacao>>(movimentacaoServices.listarMovimentacoes(), HttpStatus.OK);

    }

    @GetMapping("/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaPeloIdConta(@PathVariable("idConta") int idConta){
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoServices.listarMovimentacoesPeloIdConta(idConta), HttpStatus.OK);
    }

    @GetMapping("entradas/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaEntradasPeloIdConta(@PathVariable("idConta") int idConta){
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoServices.listarMovimentacoesDebitadasPeloIdConta(idConta), HttpStatus.OK);
    }

    @GetMapping("saidas/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaSaidasPeloIdConta(@PathVariable("idConta") int idConta){
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoServices.listarMovimentacoesCreditadasPeloIdConta(idConta), HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Movimentacao movimentacao){
        try {
            return new ResponseEntity<Movimentacao>(movimentacaoServices.incluirMovimentacao(movimentacao), HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
