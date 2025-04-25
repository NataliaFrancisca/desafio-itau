package br.com.nat.desafioitau.service;

import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.repository.TransacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class EstatisticaServiceTest {

    @InjectMocks
    private EstatisticaService estatisticaService;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Test
    @DisplayName("Deve retornar os dados da estatistica para duas transações.")
    public void deveEstatisticaConterDadosParaDuasTransacoes(){
        Transacao transacaoA = new Transacao(120, OffsetDateTime.now().minusSeconds(10));
        Transacao transacaoB = new Transacao(90, OffsetDateTime.now().minusMinutes(2));
        Transacao transacaoC = new Transacao(300, OffsetDateTime.now().minusSeconds(23));

        Map<UUID, Transacao> transacoes = Map.of(
                UUID.randomUUID(), transacaoA,  UUID.randomUUID(), transacaoB,  UUID.randomUUID(), transacaoC);

        Mockito.when(transacaoRepository.getTransacoes()).thenReturn(transacoes);

        Assertions.assertEquals(2, estatisticaService.get().getCount());
    }

    @Test
    @DisplayName("Deve retornar os valores da estatistica como zero.")
    public void deveEstatisticaConterDadosZerados(){
        Map<UUID, Transacao> transacoes = new HashMap<>();

        Mockito.when(transacaoRepository.getTransacoes()).thenReturn(transacoes);

        Assertions.assertEquals(0, estatisticaService.get().getSum());
        Assertions.assertEquals(0, estatisticaService.get().getMin());
        Assertions.assertEquals(0, estatisticaService.get().getMax());
        Assertions.assertEquals(0, estatisticaService.get().getAverage());
        Assertions.assertEquals(0, estatisticaService.get().getCount());
    }

}