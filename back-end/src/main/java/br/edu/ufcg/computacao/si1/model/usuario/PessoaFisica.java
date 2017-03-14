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
public class PessoaFisica extends Usuario {

    public PessoaFisica(String nome, String email, String senha){
        super(nome, email, senha);
    }

    public PessoaFisica() { super(); }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                super.toString() +
                '}';
    }
}
