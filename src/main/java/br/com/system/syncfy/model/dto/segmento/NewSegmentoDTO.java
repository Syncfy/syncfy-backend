package br.com.system.syncfy.model.dto.segmento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewSegmentoDTO(
//        @NotBlank(message = "O segmento não pode estar em branco.")
//        @Pattern(regexp = "[a-zA-Z]+")
        String nome
) {
}
