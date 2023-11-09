package br.com.system.syncfy.entity.transportavel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
@DiscriminatorValue("PRODUTO")
public class Produto extends Transportavel {

    private String etiqueta;
    private String nome;
    private Float peso;
    private Float largura;
    private Float altura;
    private Float profundidade;

    public Produto() {
        super(null, "PRODUTO");
    }

    public Produto(Long id, String etiqueta, String nome, Float peso, Float largura, Float altura, Float profundidade) {
        super(id, "PRODUTO");
        this.etiqueta = etiqueta;
        this.nome = nome;
        this.peso = peso;
        this.largura = largura;
        this.altura = altura;
        this.profundidade = profundidade;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Produto setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Float getPeso() {
        return peso;
    }

    public Produto setPeso(Float peso) {
        this.peso = peso;
        return this;
    }

    public Float getLargura() {
        return largura;
    }

    public Produto setLargura(Float largura) {
        this.largura = largura;
        return this;
    }

    public Float getAltura() {
        return altura;
    }

    public Produto setAltura(Float altura) {
        this.altura = altura;
        return this;
    }

    public Float getProfundidade() {
        return profundidade;
    }

    public Produto setProfundidade(Float profundidade) {
        this.profundidade = profundidade;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "etiqueta='" + etiqueta + '\'' +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", largura=" + largura +
                ", altura=" + altura +
                ", profundidade=" + profundidade +
                "} " + super.toString();
    }
}
