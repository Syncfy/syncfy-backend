package br.com.system.syncfy.controller;

import br.com.system.syncfy.model.dto.PedidoDTO;
import br.com.system.syncfy.model.dto.NewPedidoDTO;
import br.com.system.syncfy.model.entity.Pedido;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import br.com.system.syncfy.model.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private  PedidoRepository pedidoRepository;

    @GetMapping("/all")
    public Page<PedidoDTO> listar(@PageableDefault() Pageable paginacao) {
        return pedidoRepository.findAll(paginacao).map(PedidoDTO::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NewPedidoDTO dados) {
        Pedido pedido = new Pedido(dados);
        pedidoRepository.save(pedido);
        System.out.println(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obterDadosPedido(@PathVariable Long id) {
        Optional<Pedido> dadosPedidoOptional = pedidoRepository.findById(id);

        if (dadosPedidoOptional.isPresent()) {
            Pedido dadosPedido = dadosPedidoOptional.get();
            return ResponseEntity.ok(new PedidoDTO(dadosPedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoDTO dados) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.atualizar(dados);
            pedidoRepository.save(pedido);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @jakarta.transaction.Transactional
    public void excluir(@PathVariable Long id) {
        Pedido pedido = new Pedido();
        pedido = pedidoRepository.getReferenceById(id);
        pedido.excluir();
    }
}
