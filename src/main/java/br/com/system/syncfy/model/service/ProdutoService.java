package br.com.system.syncfy.model.service;

import br.com.fiap.domain.entity.transportavel.Produto;
import br.com.fiap.domain.repository.ProdutoRepository;
import br.com.fiap.infra.database.EntityManagerFactoryProvider;
import br.com.fiap.infra.security.service.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProdutoService implements Service<Produto, Long> {

    private static final AtomicReference<ProdutoService> instance = new AtomicReference<>();

    private final ProdutoRepository repo;


    private ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public static ProdutoService build(String persistenceUnit) {

        EntityManagerFactory factory = EntityManagerFactoryProvider.of(persistenceUnit).provide();
        EntityManager manager = factory.createEntityManager();
        ProdutoRepository repo = ProdutoRepository.build(manager);

        instance.compareAndSet(null, new ProdutoService(repo));
        return instance.get();
    }

    @Override
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id);
    }

    public List<Produto> findByName(String texto) {
        return repo.findByName(texto);
    }

    @Override
    public Produto persist(Produto produto) {
        return repo.persist(produto);
    }
}
