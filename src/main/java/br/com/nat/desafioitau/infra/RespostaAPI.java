package br.com.nat.desafioitau.infra;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespostaAPI {
    private String mensagem;
    private Object corpo;

    public static ResponseEntity<RespostaAPI> build(HttpStatus statusHTTP, String mensagem){
        return ResponseEntity.status(statusHTTP).body(
                new RespostaAPI(mensagem,null));
    }

    public static ResponseEntity<RespostaAPI> build(HttpStatus statusHTTP, Object corpo){
        return ResponseEntity.status(statusHTTP).body(
                new RespostaAPI(null,  corpo));
    }
}
