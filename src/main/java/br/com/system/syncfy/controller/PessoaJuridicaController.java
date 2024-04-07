package br.com.system.syncfy.controller;


import br.com.system.syncfy.model.dto.pessoa.NewPessoaJuridicaDTO;
import br.com.system.syncfy.model.dto.pessoa.AttPessoaJuridicaDTO;
import br.com.system.syncfy.model.dto.pessoa.PessoaJuridicaDTO;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import br.com.system.syncfy.model.repository.PessoaJuridicaRepository;
import br.com.system.syncfy.model.service.PessoaJuridicaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @GetMapping("/all")
    public Page<AttPessoaJuridicaDTO> listar(@PageableDefault() Pageable paginacao) {
        return pessoaJuridicaRepository.findAll(paginacao).map(AttPessoaJuridicaDTO::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NewPessoaJuridicaDTO dados) {
        var pj = NewPessoaJuridicaDTO.of(dados);
        System.out.println(pj);
        PessoaJuridica pjSaved = pessoaJuridicaRepository.save(pj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaJuridicaDTO> obterDados(@PathVariable Long id) {
        Optional<PessoaJuridica> dadosPessoaJuridicaOptional = pessoaJuridicaRepository.findById(id);

        if (dadosPessoaJuridicaOptional.isPresent()) {
            PessoaJuridica dadosPessoajuridica = dadosPessoaJuridicaOptional.get();
            return ResponseEntity.ok(new PessoaJuridicaDTO(dadosPessoajuridica));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody @Valid AttPessoaJuridicaDTO dados) {
        PessoaJuridica updatedCompany = pessoaJuridicaService.updateCompany(id, dados);
        return ResponseEntity.ok(updatedCompany);

//        public ResponseEntity<Object> atualizar(@RequestBody @Valid AttPessoaJuridicaDTO dados) {
//            Optional<PessoaJuridica> dadosPessoaJuridicaOptional = pessoaJuridicaRepository.findById(dados.codPessoa());
//            if (dadosPessoaJuridicaOptional.isPresent()) {
//                PessoaJuridica pessoaJuridica = new PessoaJuridica();
//                pessoaJuridica = pessoaJuridicaRepository.getReferenceById(dados.codPessoa());
//                pessoaJuridica.atualizar(dados);
//                return ResponseEntity.ok(new AttPessoaJuridicaDTO(pessoaJuridica));
//            }else {
//                return ResponseEntity.notFound().build();
//            }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica = pessoaJuridicaRepository.getReferenceById(id);
        pessoaJuridica.excluir();
    }

}
