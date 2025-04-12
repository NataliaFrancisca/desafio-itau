package br.com.nat.desafioitau.controller;

import br.com.nat.desafioitau.infra.RespostaAPI;
import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<RespostaAPI> create(@Valid @RequestBody Transacao transacao){
        this.transacaoService.adicionar(transacao);
        return RespostaAPI.build(HttpStatus.CREATED, "Requisição realizada com sucesso.");
    }
}
