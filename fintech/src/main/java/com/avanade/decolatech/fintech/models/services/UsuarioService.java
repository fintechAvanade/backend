package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CreateUsuarioRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.LoginRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.LoginResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.UsuarioResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.TipoConta;
import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.models.repositories.ContaRepository;
import com.avanade.decolatech.fintech.models.repositories.EnderecoRepository;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ContaService contaService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    public UsuarioResponseDto obterUsuarioPorId(int idUsuario) {
        return usuarioRepository.listarUsuarioPeloId(idUsuario);
    }

    public LoginResponseDto cadastrarUsuario(CreateUsuarioRequestDto request){
        var usuarioBanco = usuarioRepository.findByNomeUsuario(request.getNomeUsuario());

        if(usuarioBanco.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        //Mapear e salvar endereço
        var endereco = new Endereco();
        endereco.setCep(request.getCep());
        endereco.setLogradouro(request.getLogradouro());
        endereco.setComplemento(request.getComplemento());
        endereco.setBairro(request.getBairro());
        endereco.setCidade(request.getCidade());
        endereco.setEstado(request.getEstado());
        endereco.setNumero(request.getNumero());

        var enderecoDb = enderecoService.incluirEndereco(endereco);

        //Mapear e salvar usuário
        var user = new Usuario();
        user.setNome(request.getNome());
        user.setCpf(request.getCpf());
        user.setDataNascimento(request.getDataNascimento());
        user.setEmail(request.getEmail());
        user.setTelefone(request.getTelefone());
        user.setNomeUsuario(request.getNomeUsuario());
        user.setTipoUsuario(TipoUsuario.CLIENTE);
        user.setNumerosTentativasAcesso(0);
        user.setAtivo(true);
        user.setEndereco(enderecoDb);
        user.setHashSenha(passwordEncoder.encode(request.getSenha()));
        var usuarioDb = usuarioRepository.save(user);

        //Criar uma conta
        var random = new Random();
        var conta = new Conta();
        conta.setAgencia(0001);
        conta.setNumeroConta(1_000_000_000L+random.nextLong(9_000_000_000L));
        conta.setSaldo(0);
        conta.setHashSenhaPagamento(passwordEncoder.encode(String.valueOf(100000+random.nextInt(900000))));
        conta.setAtivo(true);
        conta.setTipoConta(TipoConta.SIMPLES);
        conta.setUsuario(usuarioDb);
        contaService.incluirConta(conta);

        return tokenService.logar(new LoginRequestDto(request.getNomeUsuario(), request.getSenha()));
    }

}
