package br.com.system.syncfy.infra.security.service;


import br.com.system.syncfy.infra.configuration.criptografia.PasswordEncoder;
import br.com.system.syncfy.infra.database.EntityManagerFactoryProvider;
import br.com.system.syncfy.infra.security.dto.CredenciaisDTO;
import br.com.system.syncfy.infra.security.entity.Usuario;
import br.com.system.syncfy.infra.security.repository.PessoaFisicaRepository;
import br.com.system.syncfy.infra.security.repository.UsuarioRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioService implements Service<Usuario, Long> {

    private static volatile UsuarioService instance;

    private final UsuarioRepository repo;
    private final PessoaFisicaRepository pfRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService(UsuarioRepository repo, PessoaFisicaRepository pfRepo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.pfRepo = pfRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public static UsuarioService of(String persistenceUnit, PasswordEncoder passwordEncoder) {
        UsuarioService result = instance;
        if (Objects.nonNull(result)) return result;

        synchronized (UsuarioService.class) {
            if (Objects.isNull(instance)) {
                EntityManagerFactory factory = EntityManagerFactoryProvider.of(persistenceUnit).provide();
                UsuarioRepository repo = UsuarioRepository.build(factory.createEntityManager());
                PessoaFisicaRepository pfRepo = PessoaFisicaRepository.build(factory.createEntityManager());
                instance = new UsuarioService(repo, pfRepo, passwordEncoder);
            }
            return instance;
        }
    }

    public Usuario autenticar(CredenciaisDTO dto) {
        Usuario a = repo.findByUsername(dto.username());
        var pass = dto.password();
        boolean autenticado = passwordEncoder.check(pass, a.getPassword());
        if (Objects.nonNull(a) && autenticado) {
            return a;
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Usuario persist(Usuario a) {
        return repo.persist(a);
    }
}
