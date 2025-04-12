package br.com.nat.desafioitau.repository;

import br.com.nat.desafioitau.model.Transacao;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Getter
public class TransacaoRepository {
    private Map<UUID, Transacao> transacoes;

    public TransacaoRepository(){
        this.transacoes = new HashMap<>();
    }

    public void adicionarTransacao(Transacao transacao){
        this.transacoes.put(UUID.randomUUID(), transacao);
    }
}
