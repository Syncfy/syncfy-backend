package br.com.system.syncfy.infra.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_AUTHORITY", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_AUTHORITY", columnNames = "NM_AUTHORITY")
})
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUTHORITY")
    @SequenceGenerator(name = "SQ_AUTHORITY", sequenceName = "SQ_AUTHORITY", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_AUTHORITY")
    private Long id;

    @Column(name = "NM_AUTHORITY", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    @Override
    public String getAuthority() {
        return nome;
    }
}
