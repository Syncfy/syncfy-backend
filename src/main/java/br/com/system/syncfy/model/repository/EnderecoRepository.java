package br.com.system.syncfy.model.repository;

import br.com.system.syncfy.model.entity.endereco.Endereco;
import br.com.system.syncfy.model.entity.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
