package br.com.nat.desafioitau.service;

import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.repository.TransacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {
    @InjectMocks
    private TransacaoService transacaoService;

    @Test
    @DisplayName("Deve lançar uma exceção quando o valor for menor ou igual a zero.")
    public void deveLancarUmaExcecaoQuandoValorForMenorQueZero(){
        Transacao transacao = new Transacao(-120.0, OffsetDateTime.now().minusSeconds(20));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transacaoService.adicionar(transacao));
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando a data está no futuro.")
    public void deleLancarUmaExcecaoQuandoDataEstaNoFuturo(){
        Transacao transacao = new Transacao(120.00, OffsetDateTime.now().plusHours(2));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transacaoService.adicionar(transacao));
    }

    @Test
    @DisplayName("A lista de transações deve ter uma única transação.")
    public void deveRetornarUmaListaComUmaUnicaTransacao(){
        TransacaoRepository transacaoRepository = new TransacaoRepository();
        Transacao transacao = new Transacao(120.00, OffsetDateTime.now().minusSeconds(20));

        transacaoRepository.adicionarTransacao(transacao);

        Assertions.assertEquals(1, transacaoRepository.getTransacoes().size());
        Assertions.assertTrue(transacaoRepository.getTransacoes().containsValue(transacao));
    }

    @Test
    @DisplayName("A lista de transações deve estar vazia.")
    public void deveRetornarUmaListaVazia(){
        TransacaoRepository transacaoRepository = new TransacaoRepository();
        Transacao transacao = new Transacao(120.00, OffsetDateTime.now().minusSeconds(20));

        transacaoRepository.adicionarTransacao(transacao);
        transacaoRepository.deletarTransacoes();

        Assertions.assertEquals(0, transacaoRepository.getTransacoes().size());
    }
}