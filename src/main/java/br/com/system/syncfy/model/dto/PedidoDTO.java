package br.com.system.syncfy.model.dto;

import br.com.system.syncfy.model.dto.pessoa.PessoaJuridicaDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoDTO(
        @NotNull(message = "A data de criação não pode ser nula.")
        LocalDate dataCriacao,

        LocalDate dataAtualizacao,

        @NotNull(message = "O preço total não pode ser nulo.")
        BigDecimal precoTotal,

        @NotNull(message = "A data de entrega não pode ser nula.")
        LocalDate dataEntrega,

        @NotNull(message = "O número do pedido não pode ser nulo.")
        Long numeroPedido,

        @NotBlank(message = "A descrição não pode estar em branco.")
        String descricao,

        @NotNull
        FreteDTO frete,

        @NotNull
        PessoaJuridicaDTO pj,

        @NotNull
        ProdutoDTO produto

) {
}
