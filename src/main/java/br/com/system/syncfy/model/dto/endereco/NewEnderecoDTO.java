package br.com.system.syncfy.model.dto.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record NewEnderecoDTO(

//        @NotBlank(message = "O CEP não pode estar em branco.")
//        @Pattern(regexp = "\\d{5}-\\d{3}")

        String cep,

//        @NotBlank(message = "O logradouro não pode estar em branco.")
//        @Pattern(regexp = "[a-zA-Z]+")
        String logradouro,

//        @Pattern(regexp = "\\d+")
        String numero,

//        @Pattern(regexp = "[\\w\\s]+")
        String complemento,

//        @Valid
//        @NotNull
        NewBairroDTO bairro
) {
}
