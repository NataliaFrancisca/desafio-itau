package br.com.nat.desafioitau.controller;

import br.com.nat.desafioitau.dto.EstatisticaDTO;
import br.com.nat.desafioitau.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@Tag(name = "Estatística", description = "Operações relacionadas com estatística.")
public class EstatisticaController {
    private final EstatisticaService estatisticaService;

    @Autowired
    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @Operation(summary = "Retorna estatística das transações realizadas nos últimos 60 segundos.",
            description = "Caso não tenha nenhuma transação que se encaixe na regra, os valores retornam com 0")
    @ApiResponse(
            responseCode = "200",
            description = "Estatística gerada com sucesso.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstatisticaDTO.class))
    )
    @GetMapping
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(this.estatisticaService.get());
    }
}
