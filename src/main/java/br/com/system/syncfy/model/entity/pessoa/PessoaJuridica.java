package br.com.system.syncfy.model.entity.pessoa;

import br.com.system.syncfy.model.dto.pessoa.AttPessoaJuridicaDTO;
import br.com.system.syncfy.model.entity.Segmento;
import br.com.system.syncfy.model.entity.Usuario;
import br.com.system.syncfy.model.entity.endereco.Endereco;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "PESSOA_JURIDICA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PJ_CNPJ", columnNames = {"CNPJ"})
})
@Entity
@DiscriminatorValue(value = "PJ")
public class PessoaJuridica extends Pessoa {
    @Column(name = "CNPJ", nullable = false)
    private String cnpj;
    @Column(name = "TIPO_PJ", nullable = false)
    private String tipo;

    // FKS
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "SEGMENTO", referencedColumnName = "COD_SEGMENTO", foreignKey = @ForeignKey(name = "fk_pj_segmento"))
    private Segmento segmento;

    // Construtores
    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String tipo, Segmento segmento) {
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.segmento = segmento;
    }

    public PessoaJuridica(Long codPessoa, String nome, String email, boolean softDelete, Usuario usuario, Set<Endereco> enderecos, String cnpj, String tipo, Segmento segmento) {
        super(codPessoa, nome, email, softDelete, usuario, enderecos);
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.segmento = segmento;
    }

    public PessoaJuridica(String nome, String email, boolean b, Usuario usuario, String cnpj, String tipo, Segmento segmento) {
        super(nome, email, b, usuario);
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.segmento = segmento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public PessoaJuridica setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public PessoaJuridica setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public PessoaJuridica setSegmento(Segmento segmento) {
        this.segmento = segmento;
        return this;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", tipo='" + tipo + '\'' +
                ", segmento=" + segmento +
                "} " + super.toString();
    }

    public void atualizar(AttPessoaJuridicaDTO dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setSoftDelete(dados.softDelete());
        this.setUsuario(dados.usuario());
        this.setCnpj(dados.cnpj());
        this.setTipo(dados.tipo());
        this.setSegmento(dados.segmento());
    }

    public void excluir() {
        this.setSoftDelete(true);
    }
}
