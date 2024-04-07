package br.com.system.syncfy.model.dto.segmento;

import br.com.system.syncfy.model.entity.Segmento;
import jakarta.validation.constraints.*;

import java.util.Objects;

public record SegmentoDTO(
        @NotBlank(message = "O segmento não pode estar em branco.")
        @Pattern(regexp = "[a-zA-Z]+")
        String nome
) {
}