package br.com.system.syncfy.model.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDTO(
        @NotBlank(message = "O nome de usuário não pode estar em branco.")
        String usuario
) {
}
