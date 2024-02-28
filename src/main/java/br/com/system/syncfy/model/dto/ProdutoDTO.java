package br.com.system.syncfy.model.dto;

import br.com.system.syncfy.model.entity.Produto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoDTO(
        @NotNull(message = "O valor unitário não pode ser nulo.")
        BigDecimal valorUnitario,

        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @NotBlank(message = "A descrição não pode estar em branco.")
        String descricao,

        @NotBlank(message = "O SKU não pode estar em branco.")
        String sku,

        @Valid
        CategoriaDTO categoria
) {

        public ProdutoDTO(Produto produto){
                this(
                        produto.getValorUnitario(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getSku(),
                        new CategoriaDTO(produto.getCategoria().getNome())
                );
        }
}
