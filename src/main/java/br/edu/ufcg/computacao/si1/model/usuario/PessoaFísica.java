package br.edu.ufcg.computacao.si1.model.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by adson_silva on 12/03/17.
 */
@Entity
@Table
public class PessoaFísica extends Usuario {

    @CPF
    @Column
    private String cpf;

    public PessoaFísica(String nome, String email, String senha, String cpf){
        super(nome, email, senha, "USER");

        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
