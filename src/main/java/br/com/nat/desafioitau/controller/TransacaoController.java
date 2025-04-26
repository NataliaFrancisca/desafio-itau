package br.com.nat.desafioitau.controller;

import br.com.nat.desafioitau.model.Transacao;
import br.com.nat.desafioitau.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Tag(name = "Transação", description = "Operações relacionadas a transações.")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @Operation(summary = "Adiciona uma nova transação.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso."),
            @ApiResponse(responseCode = "422", description = "A transação não foi aceita."),
            @ApiResponse(responseCode = "400", description = "A API não compreendeu a requisição.")

    })
    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody Transacao transacao){
        this.transacaoService.adicionar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transação criada com sucesso.");
    }

    @Operation(summary = "Deleta todas as transações.")
    @ApiResponse(responseCode = "200", description = "As transações foram deletadas com sucesso.")
    @DeleteMapping
    public ResponseEntity<String> delete(){
        this.transacaoService.deletar();
        return ResponseEntity.status(HttpStatus.OK).body("Todas as informações foram deletadas com sucesso.");
    }
}
