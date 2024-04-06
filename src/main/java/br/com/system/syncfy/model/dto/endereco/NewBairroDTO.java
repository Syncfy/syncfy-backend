package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewBairroDTO(
//        @NotBlank(message = "O bairro não pode estar em branco.")
        String nome,

//        @Valid
//        @NotNull
        NewCidadeDTO cidade
) {
}
