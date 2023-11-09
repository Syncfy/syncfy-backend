package br.com.system.syncfy.infra.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USER", uniqueConstraints = {
        @UniqueConstraint(name = "UK_USER_EMAIL", columnNames = "USER_EMAIL")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
    @SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Email
    @Column(name = "USER_EMAIL", nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "TB_AUTHORITY_USUARIO",
            joinColumns = {@JoinColumn(name = "USUARIO", referencedColumnName = "ID_USUARIO", foreignKey = @ForeignKey(name = "FK_AUTHORIRY_USER"))},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY", referencedColumnName = "ID_AUTHORITY", foreignKey = @ForeignKey(name = "FK_USER_AUTHORITY"))})
    private Set<Authority> authorities = new LinkedHashSet<>();

    public Usuario addAuthority(Authority a) {
        this.authorities.add(a);
        return this;
    }

    public Usuario removeAuthority(Authority a) {
        this.authorities.remove(a);
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
