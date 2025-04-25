package br.com.nat.desafioitau.controller;

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
    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody Transacao transacao){
        this.transacaoService.adicionar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("A transação foi aceita com sucesso.");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        this.transacaoService.deletar();
        return ResponseEntity.status(HttpStatus.OK).body("Todas as informações foram apagadas com sucesso.");
    }
}
