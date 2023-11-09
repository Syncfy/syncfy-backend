package br.com.system.syncfy.infra.security.dto;

import br.com.system.syncfy.Main;
import br.com.system.syncfy.infra.security.entity.PessoaFisica;
import br.com.system.syncfy.infra.security.entity.Sexo;
import br.com.system.syncfy.infra.security.entity.Usuario;
import br.com.system.syncfy.infra.security.service.PessoaFisicaService;
import br.com.system.syncfy.infra.configuration.criptografia.PasswordEncoder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

public record NewPessoaFisicaDTO(
        Long id,
        String nome,
        @PastOrPresent LocalDate nascimento,
        @Email String email,
        Sexo sexo,
        String cpf,
        CredenciaisDTO credenciais
) {
    private static PessoaFisicaService service = PessoaFisicaService.of(Main.PERSISTENCE_UNIT);
    private final PasswordEncoder passwordEncoder;

    public static NewPessoaFisicaDTO of(PessoaFisica p) {
        return new NewPessoaFisicaDTO(p.getId(), p.getNome(), p.getNascimento(), p.getEmail(), p.getSexo(), p.getCpf(), null);
    }

    public static PessoaFisica of(NewPessoaFisicaDTO p) {

        PessoaFisica pessoa = null;

        if (Objects.isNull(p)) return null;

        if (Objects.nonNull(p.id)) {
            pessoa = service.findById(p.id());
            return pessoa;
        }

        pessoa = new PessoaFisica();
        pessoa.setCpf(p.cpf);
        pessoa.setSexo(p.sexo);
        pessoa.setNome(p.nome);
        pessoa.setNascimento(p.nascimento);
        pessoa.setEmail(p.email);

        if (Objects.nonNull(p.credenciais)) {
            Usuario usuario = new Usuario();
            usuario.setUsername(p.credenciais.username()).setPassword(passwordEncoder.encode(p.credenciais.password()));
            pessoa.setUsuario(usuario);
        }
        return pessoa;
    }
}
