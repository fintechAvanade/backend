package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.utilities.JwtUtil;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginAdminRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginClienteRequestDto;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public String login(LoginAdminRequestDto request) {

        var usuario = usuarioService.buscarUsuarioPeloNomeDeUsuario(request.getUsuario());

        if(usuario.getTipoUsuario().equals(TipoUsuario.CLIENTE)) throw new BadCredentialsException("Apenas usuários administradores podem logar por esta página");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsuario(),
                request.getSenha()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        usuarioService.atualizarDataAcesso(request.getUsuario());


        String token = jwtUtil.generateToken(authentication);

        return token;
    }

    public String login(LoginClienteRequestDto request) {
        var conta = contaRepository.findByAgenciaAndNumeroConta(request.getAgencia(), request.getConta());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                conta.getUsuario().getNomeUsuario(),
                request.getSenha()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtil.generateToken(authentication);

        return token;
    }
}
