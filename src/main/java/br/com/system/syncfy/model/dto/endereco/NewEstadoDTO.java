package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record NewEstadoDTO(
//        @NotBlank(message = "O estado não pode estar em branco.")
        String nome,

//        @Valid
//        @NotBlank
        NewPaisDTO pais
) {
}
