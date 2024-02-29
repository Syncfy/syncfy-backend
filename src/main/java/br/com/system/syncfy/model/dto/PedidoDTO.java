package br.com.system.syncfy.model.dto;

import br.com.system.syncfy.model.entity.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoDTO(
        Long codPedido,

        LocalDate dataCriacao,

        LocalDate dataAtualizacao,


        BigDecimal precoTotal,


        LocalDate dataEntrega,


        Long numeroPedido,


        String descricao


) {
        public PedidoDTO(Pedido pedido){
                this(
                        pedido.getCodPedido(),
                        pedido.getDataCriacao(),
                        pedido.getDataAtualizacao(),
                        pedido.getPrecoTotal(),
                        pedido.getDataEntrega(),
                        pedido.getNumeroPedido(),
                        pedido.getDescricao()
                );
        }
}
