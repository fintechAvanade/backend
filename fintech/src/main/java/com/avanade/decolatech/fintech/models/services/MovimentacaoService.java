package com.avanade.decolatech.fintech.models.services;

import com.avanade.decolatech.fintech.models.dtos.requests.PagarComCodigoRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.TransferirRequestDto;
import com.avanade.decolatech.fintech.models.dtos.requests.ValorRequestDto;
import com.avanade.decolatech.fintech.models.dtos.responses.MovimentacoesResponseDto;
import com.avanade.decolatech.fintech.models.dtos.responses.ValorResponseDto;
import com.avanade.decolatech.fintech.models.entities.Movimentacao;
import com.avanade.decolatech.fintech.models.enums.Direcao;
import com.avanade.decolatech.fintech.models.enums.StatusMovimentacao;
import com.avanade.decolatech.fintech.models.enums.TipoMovimentacao;
import com.avanade.decolatech.fintech.models.repositories.MovimentacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoRepository.findAll();
    }

    public List<MovimentacoesResponseDto> listarMovimentacoesPeloIdConta(int idConta) {
        return movimentacaoRepository.listarMovimentacoesPorIdConta(idConta);
    }

    public List<MovimentacoesResponseDto> listarMovimentacoesCreditadasPeloIdConta(int idConta) {
        return movimentacaoRepository.listarMovimentacoesCreditadasPorIdConta(idConta);
    }

    public List<MovimentacoesResponseDto> listarMovimentacoesDebitadasPeloIdConta(int idConta) {
        return movimentacaoRepository.listarMovimentacoesDebitadasPorIdConta(idConta);
    }

    public Movimentacao salvarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @Transactional
    public ValorResponseDto sacar(int idConta, ValorRequestDto request) {
        var conta = contaService.buscarContaPeloId(idConta);

        var movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setCodigoMovimentacao(String.valueOf(UUID.randomUUID()));
        movimentacao.setStatus(StatusMovimentacao.PENDENTE);
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAQUE);
        movimentacao.setDataMovimentacao(Date.from(Instant.now()));
        movimentacao.setDirecao(Direcao.CREDITO);
        movimentacao.setDescricao(request.getDescricao());
        movimentacao.setValorMovimentacao(request.getValor());
        movimentacao.setPercentualTaxa(0);
        movimentacao.setValorTotalMovimentacao(request.getValor());

        var movimentacaoDb = this.salvarMovimentacao(movimentacao);

        if(request.getValor() > conta.getSaldo()){
            movimentacaoDb.setStatus(StatusMovimentacao.ERRO);
            this.salvarMovimentacao(movimentacaoDb);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        conta.setSaldo(conta.getSaldo()-request.getValor());
        contaService.salvarConta(conta);

        movimentacaoDb.setStatus(StatusMovimentacao.SUCESSO);
        this.salvarMovimentacao(movimentacaoDb);

        return new ValorResponseDto(request.getValor());
    }

    @Transactional
    public ValorResponseDto depositar(int idConta, ValorRequestDto request) {
        var conta = contaService.buscarContaPeloId(idConta);

        conta.setSaldo(conta.getSaldo()+request.getValor());

        var movimentacao = new Movimentacao();
        movimentacao.setConta(conta);
        movimentacao.setCodigoMovimentacao(String.valueOf(UUID.randomUUID()));
        movimentacao.setStatus(StatusMovimentacao.SUCESSO);
        movimentacao.setTipoMovimentacao(TipoMovimentacao.DEPOSITO);
        movimentacao.setDataMovimentacao(Date.from(Instant.now()));
        movimentacao.setDirecao(Direcao.DEBITO);
        movimentacao.setDescricao(request.getDescricao());
        movimentacao.setValorMovimentacao(request.getValor());
        movimentacao.setPercentualTaxa(0);
        movimentacao.setValorTotalMovimentacao(request.getValor());

        contaService.salvarConta(conta);
        this.salvarMovimentacao(movimentacao);

        return new ValorResponseDto(request.getValor());
    }


    @Transactional
    public ValorResponseDto transferenciaEntreContas(int idContaOrigem, TransferirRequestDto request) {
        if(request.getValor()<=0) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var origem = contaService.buscarContaPeloId(idContaOrigem);

        if(origem.getSaldo() < request.getValor()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var destino = contaService.buscarContaPelaAgenciaENumeroConta(request.getAgencia(), request.getConta());

        if(destino==null || !destino.isAtivo()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var codigoMovimentacao = String.valueOf(UUID.randomUUID());
        var data = Date.from(Instant.now());
        var taxa = 0.02;
        var valorTotal = request.getValor()+(request.getValor() * taxa);

        var movimentacaoOrigem = new Movimentacao(
                codigoMovimentacao,
                StatusMovimentacao.PENDENTE,
                origem,
                TipoMovimentacao.TRANSFERENCIA,
                Direcao.CREDITO,
                data,
                request.getDescricao(),
                request.getValor(),
                taxa,
                valorTotal);

        var movimentacaoDestino = new Movimentacao(
                codigoMovimentacao,
                StatusMovimentacao.PENDENTE,
                destino,
                TipoMovimentacao.TRANSFERENCIA,
                Direcao.DEBITO,
                data,
                request.getDescricao(),
                request.getValor(),
                taxa,
                valorTotal);

        var movimentacaoOrigemDb = this.salvarMovimentacao(movimentacaoOrigem);
        var movimentacaoDestinoDb = this.salvarMovimentacao(movimentacaoDestino);

        origem.setSaldo(origem.getSaldo()-valorTotal);
        destino.setSaldo(destino.getSaldo()+valorTotal);

        contaService.salvarConta(origem);
        contaService.salvarConta(destino);

        movimentacaoOrigemDb.setStatus(StatusMovimentacao.SUCESSO);
        movimentacaoDestinoDb.setStatus(StatusMovimentacao.SUCESSO);

        this.salvarMovimentacao(movimentacaoOrigem);
        this.salvarMovimentacao(movimentacaoDestino);

        return new ValorResponseDto(valorTotal);
    }

    @Transactional
    public ValorResponseDto pagarComCodigo(int idConta, PagarComCodigoRequestDto request) {
        if(request.getValor()<=0) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var conta = contaService.buscarContaPeloId(idConta);

        if(conta.getSaldo() < request.getValor()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var codigoMovimentacao = request.getCodigo();
        var data = Date.from(Instant.now());
        var taxa = 0;
        var valorTotal = request.getValor()+(request.getValor() * taxa);

        var movimentacao = new Movimentacao(
                codigoMovimentacao,
                StatusMovimentacao.PENDENTE,
                conta,
                TipoMovimentacao.PAGAMENTO_BOLETO,
                Direcao.CREDITO,
                data,
                request.getDescricao(),
                request.getValor(),
                taxa,
                valorTotal);

        var movimentacaoDb = this.salvarMovimentacao(movimentacao);

        conta.setSaldo(conta.getSaldo()-valorTotal);

        contaService.salvarConta(conta);

        movimentacaoDb.setStatus(StatusMovimentacao.SUCESSO);

        this.salvarMovimentacao(movimentacao);

        return new ValorResponseDto(valorTotal);
    }

}
