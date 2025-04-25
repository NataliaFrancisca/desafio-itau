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
    public ResponseEntity<String> handleJsonInvalido(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O corpo da requisição não foi passado.");
    }

    @ExceptionHandler({
            IllegalArgumentException.class,
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<String> handleCamposInvalidos(){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("A requisição têm valores inválidos.");
    }
}
