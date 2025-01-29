package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.MensagemResponseDto;
import com.avanade.decolatech.fintech.models.services.AuthService;
import com.avanade.decolatech.fintech.models.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("listar")
    public ResponseEntity<List<InfoContasResponseDto>> listarClientes(){
        return new ResponseEntity<List<InfoContasResponseDto>>(service.listarContas(), HttpStatus.OK);
    }


    @PostMapping("/novo")
    public ResponseEntity<LoginResponseDto> cadastrarUsuario(@RequestBody CriarClienteRequestDto request){
        try {
            var conta = service.cadastrarCliente(request);

            String token = authService.login(new LoginClienteRequestDto(conta.getAgencia(), conta.getNumeroConta(), request.getSenha()));

            var authResponse = new LoginResponseDto();
            authResponse.setAccessToken(token);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/editar/{idUsuario}")
    public ResponseEntity<MensagemResponseDto> editarCliente(@PathVariable("idUsuario") int idUsuario, @RequestBody EditarClienteRequestDto request){
        var response = service.editarCliente(idUsuario, request);
        var mensagem = new MensagemResponseDto(response);
        return new ResponseEntity<MensagemResponseDto>(mensagem, HttpStatus.ACCEPTED);
    }

    @PutMapping("/desativar/{idUsuario}")
    public ResponseEntity<MensagemResponseDto> desativarCliente(@PathVariable("idUsuario") int idUsuario){
        var response = service.alterarEstadoCliente(idUsuario, false);
        var mensagem = new MensagemResponseDto(response);
        return new ResponseEntity<MensagemResponseDto>(mensagem, HttpStatus.ACCEPTED);
    }

    @PutMapping("/ativar/{idUsuario}")
    public ResponseEntity<MensagemResponseDto> ativarCliente(@PathVariable("idUsuario") int idUsuario){
        var response = service.alterarEstadoCliente(idUsuario, true);
        var mensagem = new MensagemResponseDto(response);
        return new ResponseEntity<MensagemResponseDto>(mensagem, HttpStatus.ACCEPTED);
    }
}
