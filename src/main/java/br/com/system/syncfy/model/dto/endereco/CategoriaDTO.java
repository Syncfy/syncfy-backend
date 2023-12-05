package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(
        @NotBlank(message = "O nome da categoria não pode estar em branco.")
        String nome
) {
}
