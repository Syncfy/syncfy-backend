package br.com.system.syncfy.entity;

import br.com.fiap.Main;
import br.com.fiap.domain.entity.transportavel.Transportavel;
import br.com.fiap.domain.service.EnderecoService;
import br.com.fiap.infra.security.entity.Pessoa;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_VIAGEM")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
    @SequenceGenerator(name = "SQ_VIAGEM", sequenceName = "SQ_VIAGEM", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_VIAGEM")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "CLIENTE",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_TB_VIAGEM_CLIENTE")
    )
    private Pessoa cliente;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_VIAGEM_TRANSPORTAVEL",
            joinColumns = {
                    @JoinColumn(
                            name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(name = "FK_TB_VIAGEM_VIAGEM")
                    )
            },
            inverseJoinColumns = {

                    @JoinColumn(
                            name = "TRANSPORTAVEL",
                            referencedColumnName = "ID_TRANSPORTAVEL",
                            foreignKey = @ForeignKey(name = "FK_TB_VIAGEM_TRANSPORTAVEL")
                    )
            }
    )
    private Set<Transportavel> transportaveis = new LinkedHashSet<>();

    private String origem;

    private String destino;

    @Column(name = "DT_SAIDA")
    private LocalDateTime saida;

    @Column(name = "DT_CHEGADA")
    private LocalDateTime chegada;

    public Viagem() {
    }

    public Viagem(Long id, Pessoa cliente, Set<Transportavel> transportaveis, String origem, String destino, LocalDateTime saida, LocalDateTime chegada) {
        this.setId(id);
        this.setCliente(cliente);
        this.transportaveis = Objects.nonNull(transportaveis) && transportaveis.size() > 0 ? transportaveis : new LinkedHashSet<>();
        this.origem = origem;
        this.destino = destino;
        this.setSaida(saida);
        this.setChegada(chegada);
    }


    public Viagem(Long id, Pessoa cliente, Set<Transportavel> transportaveis, Endereco origem, Endereco destino, LocalDateTime saida, LocalDateTime chegada) {
        this.setId(id);
        this.setCliente(cliente);
        this.transportaveis = Objects.nonNull(transportaveis) && transportaveis.size() > 0 ? transportaveis : new LinkedHashSet<>();
        this.origem = origem.getCep();
        this.destino = destino.getCep();
        this.setSaida(saida);
        this.setChegada(chegada);
    }


    public Viagem addTransportavel(Transportavel t) {
        transportaveis.add(t);
        return this;
    }


    public Viagem removeTransportavel(Transportavel t) {
        transportaveis.remove(t);
        return this;
    }

    public Set<Transportavel> getTransportaveis() {
        return Collections.unmodifiableSet(transportaveis);
    }


    public Long getId() {
        return id;
    }

    public Viagem setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Viagem setCliente(Pessoa cliente) {
        this.cliente = cliente;
        return this;
    }

    public Viagem setOrigem(String origem) {
        this.origem = origem;
        return this;
    }


    public Viagem setDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public Endereco getOrigem() {
        var service = EnderecoService.build(Main.PERSISTENCE_UNIT);
        return service.findByCEP(origem);
    }


    public Endereco getDestino() {
        var service = EnderecoService.build(Main.PERSISTENCE_UNIT);
        return service.findByCEP(destino);
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public Viagem setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public Viagem setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
        return this;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + getId() +
                ", cliente=" + getCliente() +
                ", transportavel=" + getTransportaveis() +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", saida=" + getSaida() +
                ", chegada=" + getChegada() +
                '}';
    }
}
