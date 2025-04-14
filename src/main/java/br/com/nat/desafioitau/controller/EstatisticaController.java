package br.com.nat.desafioitau.controller;

import br.com.nat.desafioitau.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
public class EstatisticaController {
    private final EstatisticaService estatisticaService;

    @Autowired
    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<Object> get(){
        return ResponseEntity.status(HttpStatus.OK).body(this.estatisticaService.get());
    }
}
