package br.com.system.syncfy.model.service;

import br.com.system.syncfy.model.dto.pessoa.AttPessoaJuridicaDTO;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import br.com.system.syncfy.model.repository.PessoaJuridicaRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica updateCompany(Long id, AttPessoaJuridicaDTO pessoaJuridicaDetails) {
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found for this id :: " + id));

        pessoaJuridica.setNome(pessoaJuridicaDetails.nome());
        pessoaJuridica.setEmail(pessoaJuridicaDetails.email());
        pessoaJuridica.setSoftDelete(pessoaJuridicaDetails.softDelete());
        pessoaJuridica.setUsuario(pessoaJuridicaDetails.usuario());
        pessoaJuridica.setCnpj(pessoaJuridicaDetails.cnpj());
        pessoaJuridica.setTipo(pessoaJuridicaDetails.tipo());
        pessoaJuridica.setSegmento(pessoaJuridicaDetails.segmento());

        return pessoaJuridicaRepository.save(pessoaJuridica);
    }
}
