package br.com.system.syncfy.model.dto.pessoa;

import br.com.system.syncfy.model.dto.endereco.EnderecoDTO;
import br.com.system.syncfy.model.entity.Segmento;
import br.com.system.syncfy.model.entity.Usuario;
import br.com.system.syncfy.model.entity.endereco.Endereco;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record PessoaJuridicaDTO(
        Long codPessoa,
        String nome,
        @NotNull String email,
        boolean softDelete,

        String nomeUsuario,

        String cnpj,

        String tipo,

        Segmento segmento,
        Set<Endereco> enderecos


) {
        public PessoaJuridicaDTO(PessoaJuridica dadosPessoajuridica) {
                this(
                        dadosPessoajuridica.getCodPessoa(),
                        dadosPessoajuridica.getNome(),
                        dadosPessoajuridica.getEmail(),
                        dadosPessoajuridica.isSoftDelete(),
                        dadosPessoajuridica.getUsuario().getNome(),
                        dadosPessoajuridica.getCnpj(),
                        dadosPessoajuridica.getTipo(),
                        dadosPessoajuridica.getSegmento(),
                        dadosPessoajuridica.getEnderecos()
                );
        }
}
