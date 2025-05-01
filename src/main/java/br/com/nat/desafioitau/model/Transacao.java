package br.com.nat.desafioitau.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transacao {
    @NotNull
    @Positive(message = "Deve ter valores positivos.")
    double valor;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @PastOrPresent(message = "A transação deve ser realizada no passado, ou no presente.")
    OffsetDateTime dataHora;
}
