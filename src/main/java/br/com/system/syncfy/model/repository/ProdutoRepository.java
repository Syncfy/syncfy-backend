package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.transportavel.Produto;
import br.com.fiap.infra.security.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProdutoRepository implements Repository<Produto, Long> {

    private static final AtomicReference<ProdutoRepository> instance = new AtomicReference<>();

    private final EntityManager manager;

    private ProdutoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public static ProdutoRepository build(EntityManager manager) {
        instance.compareAndSet(null, new ProdutoRepository(manager));
        return instance.get();
    }

    @Override
    public List<Produto> findAll() {
        return manager.createQuery("From Produto").getResultList();
    }

    @Override
    public Produto findById(Long id) {
        return manager.find(Produto.class, id);
    }

    public List<Produto> findByName(String texto) {
        Query query = manager.createQuery("From Produto p where upper(p.nome) like :texto");
        query.setParameter("texto", "%" + texto.trim().toUpperCase() + "%");
        return query.getResultList();
    }

    @Override
    public Produto persist(Produto produto) {
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
        return produto;
    }
}
