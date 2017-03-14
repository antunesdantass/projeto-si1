package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Antunes Dantas on 12/03/17.
 */
@Entity
@Table(name = "tb_emprego")
public class Emprego extends Anuncio {

    public Emprego() { super(); }

    public Emprego (String titulo, double preco) {
        super(titulo, preco);
    }

}
