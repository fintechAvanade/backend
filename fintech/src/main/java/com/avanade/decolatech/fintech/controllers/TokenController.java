package com.avanade.decolatech.fintech.controllers;

import com.avanade.decolatech.fintech.models.dtos.requests.LoginAdminRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private TokenService service;

    @PostMapping("/login-admin")
    public ResponseEntity<LoginResponseDto> loginAdmin(@RequestBody LoginAdminRequestDto request){
        return new ResponseEntity<LoginResponseDto>(service.logar(request), HttpStatus.OK);
    }

    @PostMapping("/login-cliente")
    public ResponseEntity<LoginResponseDto> loginAdmin(@RequestBody LoginClienteRequestDto request){
        return new ResponseEntity<LoginResponseDto>(service.logar(request), HttpStatus.OK);
    }
}
