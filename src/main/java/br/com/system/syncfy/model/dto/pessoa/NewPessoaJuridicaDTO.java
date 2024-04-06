package br.com.system.syncfy.model.dto.pessoa;

import br.com.system.syncfy.model.dto.endereco.NewEnderecoDTO;
import br.com.system.syncfy.model.dto.segmento.NewSegmentoDTO;
import br.com.system.syncfy.model.dto.usuario.NewUsuarioDTO;
import br.com.system.syncfy.model.entity.Segmento;
import br.com.system.syncfy.model.entity.Usuario;
import br.com.system.syncfy.model.entity.endereco.*;
import br.com.system.syncfy.model.entity.pessoa.PessoaJuridica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public record NewPessoaJuridicaDTO(

        Long codPessoa,
        @NotNull String nome,
        @NotNull String email,
        boolean softDelete,
        @Valid NewUsuarioDTO usuario,
        @NotNull String cnpj,
        @NotNull String tipo,
        @Valid NewSegmentoDTO segmento,
        @Valid List<NewEnderecoDTO> enderecos
) {
    public static PessoaJuridica of(NewPessoaJuridicaDTO pj) {
        PessoaJuridica pessoa = null;

        if (Objects.isNull(pj)) return null;

        //Valida usuario já existente
//        if (Objects.nonNull(pj.codPessoa)) {
//            pessoa = service.findById(p.id());
//            return pessoa;
//        }

        pessoa = new PessoaJuridica();
        pessoa.setNome(pj.nome);
        pessoa.setEmail(pj.email);
        pessoa.setSoftDelete(pj.softDelete);

        if (Objects.nonNull(pj.usuario)) {
            Usuario usuario = new Usuario();
            usuario.setNome(pj.usuario.nome()).setSenha(pj.usuario.senha());
            pessoa.setUsuario(usuario);
        }

        pessoa.setCnpj(pj.cnpj);
        pessoa.setTipo(pj.tipo);

        if (Objects.nonNull(pj.segmento)) {
            Segmento segmento = new Segmento();
            segmento.setNome(pj.segmento.nome());
            pessoa.setSegmento(segmento);
        }

        if (Objects.nonNull(pj.enderecos()) && !pj.enderecos().isEmpty()) {
            Set<Endereco> enderecos = pj.enderecos().stream().map(dto -> {
                Endereco endereco = new Endereco();
                endereco.setCep(dto.cep());
                endereco.setLogradouro(dto.logradouro());
                endereco.setNumero(dto.numero());
                endereco.setComplemento(dto.complemento());

                if (Objects.nonNull(dto.bairro())) {
                    Bairro bairro = new Bairro();
                    bairro.setNome(dto.bairro().nome());

                    if (Objects.nonNull(dto.bairro().cidade())) {
                        Cidade cidade = new Cidade();
                        cidade.setNome(dto.bairro().cidade().nome());
                        cidade.setCodIbge(dto.bairro().cidade().codIbge());

                        if (Objects.nonNull(dto.bairro().cidade().estado())) {
                            Estado estado = new Estado();
                            estado.setNome(dto.bairro().cidade().estado().nome());

                            if (Objects.nonNull(dto.bairro().cidade().estado().pais())) {
                                Pais pais = new Pais();
                                pais.setNome(dto.bairro().cidade().estado().pais().nome());
                                estado.setPais(pais);
                            }
                            cidade.setEstado(estado);
                        }
                        bairro.setCidade(cidade);
                    }
                    endereco.setBairro(bairro);
                }
                return endereco;
            }).collect(Collectors.toSet());
            pessoa.setEnderecos(enderecos);
            for (Endereco endereco : enderecos) {
                endereco.setPessoa(pessoa);
            }
        }
        return pessoa;
    }
}