package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.LoginAdminRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.services.AuthService;
import com.avanade.decolatech.fintech.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @Autowired
    private AuthService authService;


    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDto> obterUsuarioPorId(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<UsuarioResponseDto>(service.buscarUsuarioResponsePorId(idUsuario), HttpStatus.OK);
    }

    @PostMapping("/login-admin")
    public ResponseEntity<LoginResponseDto> loginAdmin(@RequestBody LoginAdminRequestDto request){
        try {
            String token = authService.login(request);

            var authResponse = new LoginResponseDto();
            authResponse.setAccessToken(token);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login-cliente")
    public ResponseEntity<LoginResponseDto> loginCliente(@RequestBody LoginClienteRequestDto request) {
        try {
            String token = authService.login(request);

            var authResponse = new LoginResponseDto();
            authResponse.setAccessToken(token);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
