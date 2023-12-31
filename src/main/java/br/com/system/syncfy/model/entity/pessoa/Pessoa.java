package br.com.system.syncfy.model.entity.pessoa;

import br.com.system.syncfy.model.dto.pessoa.PessoaJuridicaDTO;
import br.com.system.syncfy.model.entity.endereco.Endereco;
import br.com.system.syncfy.model.entity.Usuario;
import jakarta.persistence.*;

@Table(name = "PESSOA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PESSOA_EMAIL", columnNames = {"EMAIL"})
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1, initialValue = 1)
    @Column(name = "COD_PESSOA")
    private Long codPessoa;
    @Column(name = "NOME_PESSOA", nullable = false)
    private String nome;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "DELETE_PESSOA")
    private boolean softDelete;

    // FKS
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "USUARIO", referencedColumnName = "COD_USER", foreignKey = @ForeignKey(name = "fk_pessoa_usuario"))
    private Usuario usuario;

    public Pessoa() {
    }

    public Pessoa(Long codPessoa, String nome, String email, boolean softDelete, Usuario usuario) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.email = email;
        this.softDelete = softDelete;
        this.usuario = usuario;
    }

    public Pessoa(String nome, String email, boolean softDelete, Usuario usuario) {
        this.nome = nome;
        this.email = email;
        this.softDelete = softDelete;
        this.usuario = usuario;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }

    public Pessoa setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pessoa setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public Pessoa setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pessoa setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "codPessoa=" + codPessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", softDelete=" + softDelete +
                ", usuario=" + usuario +
                '}';
    }
}
