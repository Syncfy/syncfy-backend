package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.constraints.Pattern;

public record NewBairroDTO(
        //        @NotBlank(message = "O bairro não pode estar em branco.")
        @Pattern(regexp = "[a-zA-Z]+")
        String nome,

//        @Valid
//        @NotBlank
        NewCidadeDTO cidade
) {
}
