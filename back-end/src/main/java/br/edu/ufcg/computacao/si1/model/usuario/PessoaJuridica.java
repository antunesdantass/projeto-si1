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
public class PessoaJuridica extends Usuario {

    public PessoaJuridica(String nome, String email, String senha){
        super(nome, email, senha);
    }

    public PessoaJuridica() { super(); }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                super.toString() +
                '}';
    }
}
