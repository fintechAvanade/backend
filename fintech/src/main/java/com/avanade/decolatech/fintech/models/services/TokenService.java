package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.LoginAdminRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public LoginResponseDto logar(LoginAdminRequestDto request){
        var user = usuarioRepository.findByNomeUsuario(request.getUsuario());

        if(user.isEmpty() || !user.get().isLoginCorrect(request, passwordEncoder))
            throw new BadCredentialsException("Usuário ou senha são inválidos");

        var now = Instant.now();
        var expiresIn = 3000L;

        var scope = user.get().getTipoUsuario().toString();

        var claims = JwtClaimsSet.builder()
                .issuer("fintech")
                .subject(String.valueOf(user.get().getId()))
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scope)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDto(jwtValue,expiresIn);
    }

    public LoginResponseDto logar(LoginClienteRequestDto request){

        var conta = contaRepository.findByAgenciaAndNumeroConta(request.getAgencia(), request.getConta());
        var user = usuarioRepository.findByNomeUsuario(conta.get().getUsuario().getNomeUsuario());

        if(conta.isEmpty() || !user.get().isLoginCorrect(request, passwordEncoder))
            throw new BadCredentialsException("Usuário ou senha são inválidos");

        var now = Instant.now();
        var expiresIn = 3000L;

        var scope = user.get().getTipoUsuario().toString();

        var claims = JwtClaimsSet.builder()
                .issuer("fintech")
                .subject(String.valueOf(user.get().getId()))
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .claim("scope", scope)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDto(jwtValue,expiresIn);
    }
}
