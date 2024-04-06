package br.com.system.syncfy.model.dto.segmento;

import jakarta.validation.constraints.*;

public record SegmentoDTO(
        @NotBlank(message = "O segmento não pode estar em branco.")
        @Pattern(regexp = "[a-zA-Z]+")
        String nome
) {
}