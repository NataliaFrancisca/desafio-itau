package br.com.nat.desafioitau.service;

import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    private TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    private void validarTransacao(Transacao transacao){
        OffsetDateTime dataRequisicao = OffsetDateTime.now();

        if(transacao.getValor() < 0 || transacao.getDataHora().isAfter(dataRequisicao)){
            throw new IllegalArgumentException("A transação têm valores inválidos.");
        }
    }

    public void adicionar(Transacao transacao){
        this.validarTransacao(transacao);
        this.transacaoRepository.adicionarTransacao(transacao);
    }
}
