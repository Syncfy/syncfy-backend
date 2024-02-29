package br.com.system.syncfy.model.entity;

import br.com.system.syncfy.model.dto.PedidoDTO;
import br.com.system.syncfy.model.dto.NewPedidoDTO;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "PEDIDO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PEDIDO_NUMERO_PEDIDO", columnNames = {"NUMERO_PEDIDO"})
})
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PEDIDO")
    @SequenceGenerator(name = "SQ_PEDIDO", sequenceName = "SQ_PEDIDO", allocationSize = 1, initialValue = 1)
    @Column(name = "COD_PEDIDO")
    private Long codPedido;
    @Column(name = "DATA_CRIACAO_PEDIDO")
    private LocalDate dataCriacao;
    @Column(name = "DATA_ATUALIZACAO_PEDIDO")
    private LocalDate dataAtualizacao;
    @Column(name = "PRECO_TOTAL_PEDIDO")
    private BigDecimal precoTotal;
    @Column(name = "DATA_ENTREGA_PEDIDO")
    private LocalDate dataEntrega;
    @Column(name = "NUMERO_PEDIDO")
    private Long numeroPedido;
    @Column(name = "DESCRICAO_PEDIDO")
    private String descricao;

    // FKS
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "FRETE", referencedColumnName = "COD_FRETE", foreignKey = @ForeignKey(name = "fk_pedido_frete"))
    private Frete frete;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PESSOA_JURIDICA",
            referencedColumnName = "COD_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PEDIDO_PESSOA_JURIDICA")
    )
    private PessoaJuridica pessoaJuridica;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_PEDIDO_PRODUTO",
            joinColumns = {
                    @JoinColumn(
                            name = "PEDIDO",
                            referencedColumnName = "COD_PEDIDO",
                            foreignKey = @ForeignKey(name = "FK_PEDIDO_PEDIDO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "COD_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO")
                    )
            }
    )
    private Set<Produto> produtos = new LinkedHashSet<>();

    public Pedido() {
    }

    public Pedido(Long codPedido, LocalDate dataCriacao, LocalDate dataAtualizacao, BigDecimal precoTotal, LocalDate dataEntrega, Long numeroPedido, String descricao, Frete frete, PessoaJuridica pessoaJuridica, Set<Produto> produtos) {
        this.codPedido = codPedido;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.precoTotal = precoTotal;
        this.dataEntrega = dataEntrega;
        this.numeroPedido = numeroPedido;
        this.descricao = descricao;
        this.frete = frete;
        this.pessoaJuridica = pessoaJuridica;
        this.produtos = produtos;
    }

    public Pedido(NewPedidoDTO dados) {
        this.dataCriacao = dados.dataCriacao();
        this.dataAtualizacao = dados.dataAtualizacao();
        this.dataEntrega = dados.dataEntrega();
        this.numeroPedido = dados.numeroPedido();
        this.descricao = dados.descricao();
        this.precoTotal = dados.precoTotal();
        this.frete = frete;
        this.pessoaJuridica = pessoaJuridica;
        this.produtos = produtos;
    }

    public Long getCodPedido() {
        return codPedido;
    }

    public Pedido setCodPedido(Long codPedido) {
        this.codPedido = codPedido;
        return this;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Pedido setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Pedido setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
        return this;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public Pedido setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
        return this;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public Pedido setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
        return this;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public Pedido setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pedido setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Frete getFrete() {
        return frete;
    }

    public Pedido setFrete(Frete frete) {
        this.frete = frete;
        return this;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public Pedido setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
        return this;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public Pedido setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codPedido=" + codPedido +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", precoTotal=" + precoTotal +
                ", dataEntrega=" + dataEntrega +
                ", numeroPedido=" + numeroPedido +
                ", descricao='" + descricao + '\'' +
                ", frete=" + frete +
                ", pessoaJuridica=" + pessoaJuridica +
                ", produtos=" + produtos +
                '}';
    }
    public void atualizar(PedidoDTO dados) {
        this.setDataCriacao(dados.dataCriacao());
        this.setDataAtualizacao(dados.dataAtualizacao());
        this.setPrecoTotal(dados.precoTotal());
        this.setDataEntrega(dados.dataEntrega());
        this.setNumeroPedido(dados.numeroPedido());
        this.setDescricao(dados.descricao());
    }

    public void excluir() {
        this.setDataCriacao(null);
        this.setDataAtualizacao(null);
        this.setPrecoTotal(null);
        this.setDataEntrega(null);
        this.setNumeroPedido(null);
        this.setDescricao(null);
    }
}
