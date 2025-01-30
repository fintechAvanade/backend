package com.avanade.decolatech.fintech.utilities;

import java.security.Key;
import java.util.Date;


import javax.crypto.SecretKey;


import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${app.jwt-secret}")
    private String jwtSecret;


    @Value("${app.jwt-expiration}")
    private long jwtExpirationDate;

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    public String getUsername(String token){


        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


    public boolean validateToken(String token){
        Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parse(token);
        return true;


    }

    public String generateToken(Authentication authentication){

        String username = authentication.getName();

        var usuario = usuarioRepository.getUserByUsername(username);

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        var tokenBuilder = Jwts.builder()
                .subject(username)
                .claim("id", usuario.getId())
                .claim("role", usuario.getTipoUsuario().toString())
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key());

        if(usuario.getTipoUsuario() == TipoUsuario.CLIENTE)
            return tokenBuilder
                .claim("contaId", usuario.getContas().getFirst().getId())
                .compact();

        return tokenBuilder.compact();
    }
}

