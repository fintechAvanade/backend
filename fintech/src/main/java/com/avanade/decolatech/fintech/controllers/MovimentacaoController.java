package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.PagarComCodigoRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.TransferirRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.ValorRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.MovimentacoesResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaPeloIdConta(@PathVariable("idConta") int idConta){
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoService.listarMovimentacoesPeloIdConta(idConta), HttpStatus.OK);
    }

    @GetMapping("entradas/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaEntradasPeloIdConta(@PathVariable("idConta") int idConta){
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoService.listarMovimentacoesDebitadasPeloIdConta(idConta), HttpStatus.OK);
    }

    @GetMapping("saidas/{idConta}")
    public ResponseEntity<List<MovimentacoesResponseDto>> listaSaidasPeloIdConta(@PathVariable("idConta") int idConta) {
        return new ResponseEntity<List<MovimentacoesResponseDto>>(movimentacaoService.listarMovimentacoesCreditadasPeloIdConta(idConta), HttpStatus.OK);
    }

    @PostMapping("/sacar/{idConta}")
    public ResponseEntity<ValorResponseDto> sacar(@PathVariable("idConta") int idConta, @RequestBody ValorRequestDto request){
        return new ResponseEntity<ValorResponseDto>(movimentacaoService.sacar(idConta, request), HttpStatus.OK);
    }

    @PostMapping("/depositar/{idConta}")
    public ResponseEntity<ValorResponseDto> depositar(@PathVariable("idConta") int idConta, @RequestBody ValorRequestDto request){
        return new ResponseEntity<ValorResponseDto>(movimentacaoService.depositar(idConta, request), HttpStatus.OK);
    }

    @PostMapping("/transferir/{idConta}")
    public ResponseEntity<ValorResponseDto> transferir(@PathVariable("idConta") int idContaOrigem, @RequestBody TransferirRequestDto request){
        return new ResponseEntity<ValorResponseDto>(movimentacaoService.transferenciaEntreContas(idContaOrigem, request), HttpStatus.OK);
    }

    @PostMapping("/pagar-codigo/{idConta}")
    public ResponseEntity<ValorResponseDto> pagarComCodigo(@PathVariable("idConta") int idConta, @RequestBody PagarComCodigoRequestDto request){
        return new ResponseEntity<ValorResponseDto>(movimentacaoService.pagarComCodigo(idConta, request), HttpStatus.OK);
    }
}
