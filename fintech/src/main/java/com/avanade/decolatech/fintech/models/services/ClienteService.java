package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.CriarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.EditarClienteRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.EditarClienteResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.InfoContasResponseDto;
import com.avanade.decolatech.fintech.models.entities.Conta;
import com.avanade.decolatech.fintech.models.enums.TipoConta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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


    public List<InfoContasResponseDto> listarContas(){
        return contaService.listarContasAdmin();
    }

    public EditarClienteResponseDto buscarClientePorIdConta(int idConta){
        return usuarioService.buscarUsuarioEnderecoPorId(idConta);
    }

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
    public String editarCliente(int idConta, EditarClienteRequestDto request) {

        var contaDb = contaService.buscarContaPeloId(idConta);

        var usuarioDb = contaDb.getUsuario();

        if(usuarioDb == null || !usuarioDb.isAtivo()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var endereco = enderecoService.editarEndereco(request, usuarioDb.getEndereco());

        var usuario = usuarioService.editarUsuario(request, usuarioDb, endereco);

        contaDb.setTipoConta(TipoConta.valueOf(request.getTipoConta()));
        contaService.salvarConta(contaDb);

        return "Cliente editado com sucesso";
    }

    @Transactional
    public String alterarEstadoCliente(int idConta, boolean estado) {
        var conta = contaService.buscarContaPeloId(idConta);
        var usuario = conta.getUsuario();
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
