package br.com.nat.desafioitau.infra;

import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler({
            JsonMappingException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<RespostaAPI> handleJsonInvalido(){
        return RespostaAPI.build(HttpStatus.BAD_REQUEST, "O corpo da requisição não foi passado.");
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<RespostaAPI> handleCamposInvalidos(){
        return RespostaAPI.build(HttpStatus.UNPROCESSABLE_ENTITY, "Campos inválidos.");
    }
}
