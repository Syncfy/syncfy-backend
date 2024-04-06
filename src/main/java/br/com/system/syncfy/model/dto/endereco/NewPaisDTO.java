package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewPaisDTO(
//        @NotBlank(message = "O país não pode estar em branco.")
        String nome
) {
}
