package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.constraints.Pattern;

public record PaisDTO(
//        @NotBlank(message = "O país não pode estar em branco.")
        @Pattern(regexp = "[a-zA-Z\\s]+")
        String pais
) {
}
