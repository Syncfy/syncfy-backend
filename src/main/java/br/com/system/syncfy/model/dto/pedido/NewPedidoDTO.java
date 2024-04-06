package br.com.system.syncfy.model.dto.pedido;

import br.com.system.syncfy.model.dto.frete.FreteDTO;
import br.com.system.syncfy.model.dto.pessoa.AttPessoaJuridicaDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record NewPedidoDTO(
        LocalDate dataCriacao,
        LocalDate dataAtualizacao,
        LocalDate dataEntrega,
        Long numeroPedido,
        String descricao,
        BigDecimal precoTotal,
        FreteDTO freteId,
        AttPessoaJuridicaDTO pessoaJuridicaId,
        Set<Long> produtoIds
) {}