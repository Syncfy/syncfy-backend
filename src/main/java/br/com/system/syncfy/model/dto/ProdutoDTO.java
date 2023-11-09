package br.com.system.syncfy.model.dto;

import br.com.fiap.Main;
import br.com.fiap.domain.entity.transportavel.Produto;
import br.com.fiap.domain.service.ProdutoService;

import java.util.Objects;

public record ProdutoDTO(
        Long id,
        String tipo,
        String nome,
        String etiqueta,
        Float altura,
        Float largura,
        Float profundidade,
        Float peso) {

    private static ProdutoService service = ProdutoService.build(Main.PERSISTENCE_UNIT);

    public static Produto of(ProdutoDTO dto) {

        // É nulo?
        if (Objects.isNull(dto)) return null;

        //Ele informou o id do produto?
        if (Objects.nonNull(dto.id)) return service.findById(dto.id);

        Produto p = new Produto();
        p.setNome(dto.nome);
        p.setAltura(dto.altura);
        p.setLargura(dto.largura);
        p.setProfundidade(dto.profundidade);
        p.setPeso(dto.peso);
        p.setEtiqueta(dto.etiqueta);
        return p;
    }

    public static ProdutoDTO of(Produto p) {
        if (Objects.isNull(p)) return null;
        return new ProdutoDTO(p.getId(), p.getTipo(), p.getNome(), p.getEtiqueta(), p.getAltura(), p.getLargura(), p.getProfundidade(), p.getPeso());
    }

}
