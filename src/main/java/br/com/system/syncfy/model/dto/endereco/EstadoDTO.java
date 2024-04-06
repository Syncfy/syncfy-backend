package br.com.system.syncfy.model.dto.endereco;

public record EstadoDTO(
//        @NotBlank(message = "O estado não pode estar em branco.")
        String estado,

//        @Valid
//        @NotBlank
        PaisDTO pais
){
}
