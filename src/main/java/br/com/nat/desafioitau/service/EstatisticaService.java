package br.com.nat.desafioitau.service;

import br.com.nat.desafioitau.dto.EstatisticaDTO;
import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class EstatisticaService {
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public EstatisticaService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    private List<Double> filtrarTransacoesUltimoMinuto(){
        final int SEGUNDOS = 60;

        List<Transacao> transacaos = this.transacaoRepository.getTransacoes().values().stream().toList();

        OffsetDateTime horaAtualMenosUmMinuto = OffsetDateTime.now().minusSeconds(SEGUNDOS);

        return transacaos.stream().filter(transacao -> transacao.getDataHora().isAfter(horaAtualMenosUmMinuto)).map(Transacao::getValor).toList();
    }

    private EstatisticaDTO gerarEstatisticas(){
        List<Double> transacoes = this.filtrarTransacoesUltimoMinuto();

        if(transacoes.isEmpty()){
            return EstatisticaDTO.retornarEstatisticasVazias();
        }

        DoubleStream transacoesDouble = transacoes.stream().mapToDouble(Double::doubleValue);

        return EstatisticaDTO.retornarEstatisticasCompletas(transacoesDouble.summaryStatistics());
    }

    public EstatisticaDTO get(){
        return this.gerarEstatisticas();
    }
}
