package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.EditarClienteResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPorId(int idUsuario){
        return usuarioRepository.getReferenceById(idUsuario);
    }

    public UsuarioResponseDto buscarUsuarioResponsePorId(int idUsuario){
        return usuarioRepository.buscarUsuarioPeloId(idUsuario);
    }

    public EditarClienteResponseDto buscarUsuarioEnderecoPorId(int idUsuario){
        return usuarioRepository.buscarUsuarioEnderecoPorId(idUsuario);
    }

    public void atualizarDataAcesso(String nomeUsuario){
        var usuario = usuarioRepository.getUserByUsername(nomeUsuario);

        usuario.setDataUltimoAcesso(Date.from(Instant.now()));

        salvarUsuario(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.getUserByUsername(username);

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(usuario.getTipoUsuario().toString()));

        return new org.springframework.security.core.userdetails.User(
                username,
                usuario.getHashSenha(),
                authorities
        );
    }

    public boolean usuarioExiste(String nomeUsuario){
        var usuario =  usuarioRepository.findByNomeUsuario(nomeUsuario);
        return usuario.isPresent();
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario criarUsuario(CriarClienteRequestDto request, Endereco endereco){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senha = passwordEncoder.encode(request.getSenha());

        var usuario = new Usuario();

        usuario.setNome(request.getNome());
        usuario.setCpf(request.getCpf());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setEmail(request.getEmail());
        usuario.setTelefone(request.getTelefone());
        usuario.setNomeUsuario(request.getNomeUsuario());
        usuario.setTipoUsuario(TipoUsuario.CLIENTE);
        usuario.setNumerosTentativasAcesso(0);
        usuario.setAtivo(true);
        usuario.setEndereco(endereco);
        usuario.setHashSenha(senha);

        return salvarUsuario(usuario);
    }

    public Usuario editarUsuario(EditarClienteRequestDto request, Usuario usuario, Endereco endereco){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senha = passwordEncoder.encode(request.getSenha());

        usuario.setNome(request.getNome());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setEmail(request.getEmail());
        usuario.setTelefone(request.getTelefone());
        usuario.setNomeUsuario(request.getNomeUsuario());
        usuario.setEndereco(endereco);
        usuario.setHashSenha(senha);

        return salvarUsuario(usuario);
    }
}
