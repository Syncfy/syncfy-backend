package br.com.system.syncfy.entity.transportavel;

import br.com.system.syncfy.infra.security.entity.PessoaFisica;
import jakarta.persistence.*;


@Entity
@Table(name = "TB_PASSAGEIRO")
@DiscriminatorValue("PASSAGEIRO")
public class Passageiro extends Transportavel {

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_TB_PASSAGEIRO_PESSOA"
            )
    )
    private PessoaFisica pessoa;

    public Passageiro() {
        super(null, "PASSAGEIRO");
    }

    public Passageiro(Long id, PessoaFisica pessoa) {
        super(id, "PASSAGEIRO");
        this.pessoa = pessoa;
    }

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public Passageiro setPessoa(PessoaFisica pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "pessoa=" + pessoa +
                "} " + super.toString();
    }
}
