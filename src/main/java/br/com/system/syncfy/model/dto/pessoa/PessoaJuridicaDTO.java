package br.com.system.syncfy.model.dto.pessoa;

import br.com.system.syncfy.model.dto.usuario.UsuarioDTO;
import br.com.system.syncfy.model.entity.Segmento;
import br.com.system.syncfy.model.entity.Usuario;
import br.com.system.syncfy.model.entity.endereco.Endereco;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PessoaJuridicaDTO(
        Long codPessoa,
        String nome,
        @NotNull String email,
        boolean softDelete,

        UsuarioDTO usuario,

        String cnpj,

        String tipo,

        Segmento segmento,

        Set<Endereco> enderecos

) {
        public PessoaJuridicaDTO(PessoaJuridica pessoaJuridica){
                this(
                        pessoaJuridica.getCodPessoa(),
                        pessoaJuridica.getNome(),
                        pessoaJuridica.getEmail(),
                        pessoaJuridica.isSoftDelete(),
                        new UsuarioDTO(pessoaJuridica.getUsuario().getCodUser(), pessoaJuridica.getUsuario().getNome()),
                        pessoaJuridica.getCnpj(),
                        pessoaJuridica.getTipo(),
                        pessoaJuridica.getSegmento(),
                        pessoaJuridica.getEnderecos()
                );
        }
}
