package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by adson_silva on 12/03/17.
 */
@Entity
@Table
public class PessoaJuridica extends Usuario{

    @CNPJ
    @Column
    private String cnpj;

    public PessoaJuridica(String nome, String email, String senha, String cnpj){
        super(nome, email, senha, "COMPANY");

        this.cnpj = cnpj;

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
