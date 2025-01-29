package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarClienteRequestDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.enums.TipoConta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ContaService contaService;

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private ChavePixService chavePixService;

    @Transactional
    public Conta cadastrarCliente(CriarClienteRequestDto request) {

        if(usuarioService.usuarioExiste(request.getNomeUsuario())) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var endereco = enderecoService.salvarEndereco(request);

        var usuario = usuarioService.criarUsuario(request, endereco);

       var conta = contaService.criarContaSimples(usuario);

       var cartao = cartaoService.criarCartao(conta);

        return conta;
    }

    @Transactional
    public String editarCliente(int idUsuario, EditarClienteRequestDto request) {

        var usuarioDb = usuarioService.buscarUsuarioPorId(idUsuario);

        if(usuarioDb==null || !usuarioDb.isAtivo()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var endereco = enderecoService.editarEndereco(request, usuarioDb.getEndereco());

        var usuario = usuarioService.editarUsuario(request, usuarioDb, endereco);

        var conta = contaService.buscarContaPeloUsuario(usuario);
        conta.setTipoConta(TipoConta.valueOf(request.getTipoConta()));
        contaService.salvarConta(conta);

        return "Cliente editado com sucesso";
    }

    @Transactional
    public String alterarEstadoCliente(int idUsuario, boolean estado) {
        var usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        var conta = contaService.buscarContaPeloUsuario(usuario);
        var chavesPix = chavePixService.buscarTodasChavesPixPelaConta(conta);
        var cartoes = cartaoService.buscarCartaoPelaConta(conta);

        usuario.setAtivo(estado);
        conta.setAtivo(estado);

        for (int i = 0; i < chavesPix.size(); i++) {
            chavesPix.get(i).setAtivo(estado);
        }

        for (int i = 0; i < cartoes.size(); i++) {
            cartoes.get(i).setAtivo(estado);
        }

        usuarioService.salvarUsuario(usuario);
        contaService.salvarConta(conta);
        cartaoService.salvarCartoes(cartoes);
        chavePixService.salvarChavesPix(chavesPix);

        return estado == true ? "Usuário ativado com sucesso" : "Usuário desativado com sucesso";
    }
}
