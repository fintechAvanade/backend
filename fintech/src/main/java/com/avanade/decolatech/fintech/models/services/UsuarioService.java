package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginAdminRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Cartao;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.TipoConta;
import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

//    public UsuarioResponseDto buscarUsuarioPorId(int idUsuario) {
//        return usuarioRepository.buscarUsuarioPeloId(idUsuario);
//    }

//    @Transactional
//    public LoginResponseDto cadastrarUsuario(CriarUsuarioRequestDto request){
//        var usuarioBanco = usuarioRepository.findByNomeUsuario(request.getNomeUsuario());
//
//        if(usuarioBanco.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
//
//        var endereco = new Endereco();
//        endereco.setCep(request.getCep());
//        endereco.setLogradouro(request.getLogradouro());
//        endereco.setComplemento(request.getComplemento());
//        endereco.setBairro(request.getBairro());
//        endereco.setCidade(request.getCidade());
//        endereco.setEstado(request.getEstado());
//        endereco.setNumero(request.getNumero());
//
//        var enderecoDb = enderecoService.salvarEndereco(endereco);
//
//        var user = new Usuario();
//        user.setNome(request.getNome());
//        user.setCpf(request.getCpf());
//        user.setDataNascimento(request.getDataNascimento());
//        user.setEmail(request.getEmail());
//        user.setTelefone(request.getTelefone());
//        user.setNomeUsuario(request.getNomeUsuario());
//        user.setTipoUsuario(TipoUsuario.CLIENTE);
//        user.setNumerosTentativasAcesso(0);
//        user.setAtivo(true);
//        user.setEndereco(enderecoDb);
//        user.setHashSenha(passwordEncoder.encode(request.getSenha()));
//        var usuarioDb = usuarioRepository.save(user);
//
//        var random = new Random();
//        var conta = new Conta();
//        conta.setAgencia("0001");
//        conta.setNumeroConta(String.valueOf(1_000_000_000L+random.nextLong(9_000_000_000L)));
//        conta.setSaldo(0);
//        conta.setHashSenhaPagamento(passwordEncoder.encode(String.valueOf(100000+random.nextInt(900000))));
//        conta.setAtivo(true);
//        conta.setTipoConta(TipoConta.SIMPLES);
//        conta.setUsuario(usuarioDb);
//        var contaDb = contaService.salvarConta(conta);
//
//        var cartao = new Cartao();
//        cartao.setNumeroCartao(String.valueOf(1_000_000_000_000_000L+random.nextLong(9_000_000_000_000_000L)));
//        cartao.setCvv(String.valueOf(100+random.nextInt(900)));
//        cartao.setDataValidadeCartao(Date.from(LocalDate.now().plusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        cartao.setConta(contaDb);
//        cartao.setAtivo(true);
//        cartaoService.salvarCartao(cartao);
//
//        return tokenService.logar(new LoginAdminRequestDto(request.getNomeUsuario(), request.getSenha()));
//    }

//    @Transactional
//    public String editarUsuario(int idUsuario, EditarUsuarioRequestDto request) {
//
//        var usuario = usuarioRepository.getReferenceById(idUsuario);
//
//        var endereco = usuario.getEndereco();
//
//        endereco.setCep(request.getCep());
//        endereco.setLogradouro(request.getLogradouro());
//        endereco.setComplemento(request.getComplemento());
//        endereco.setBairro(request.getBairro());
//        endereco.setCidade(request.getCidade());
//        endereco.setEstado(request.getEstado());
//        endereco.setNumero(request.getNumero());
//
//        usuario.setNome(request.getNome());
//        usuario.setDataNascimento(request.getDataNascimento());
//        usuario.setEmail(request.getEmail());
//        usuario.setTelefone(request.getTelefone());
//        usuario.setNomeUsuario(request.getNomeUsuario());
//        usuario.setEndereco(endereco);
//        usuario.setHashSenha(passwordEncoder.encode(request.getSenha()));
//
//        var conta = contaService.buscarContaPeloUsuario(usuario);
//
//        conta.setTipoConta(TipoConta.valueOf(request.getTipoConta()));
//
//        usuarioRepository.save(usuario);
//        enderecoService.salvarEndereco(endereco);
//        contaService.salvarConta(conta);
//
//        return "Usuário editado com sucesso";
//    }

//    @Transactional
//    public String alterarEstadoUsuario(int idUsuario, boolean estado) {
//        var usuario = usuarioRepository.getReferenceById(idUsuario);
//        var conta = contaService.buscarContaPeloUsuario(usuario);
//        var chavesPix = chavePixService.buscarTodasChavesPixPelaConta(conta);
//        var cartoes = cartaoService.buscarCartaoPelaConta(conta);
//
//        usuario.setAtivo(estado);
//        conta.setAtivo(estado);
//
//        for (int i = 0; i < chavesPix.size(); i++) {
//            chavesPix.get(i).setAtivo(estado);
//        }
//
//        for (int i = 0; i < cartoes.size(); i++) {
//            cartoes.get(i).setAtivo(estado);
//        }
//
//        usuarioRepository.save(usuario);
//        contaService.salvarConta(conta);
//        cartaoService.salvarCartoes(cartoes);
//        chavePixService.salvarChavesPix(chavesPix);
//
//        return estado == true ? "Usuário ativado com sucesso" : "Usuário desativado com sucesso";
//    }
}
