package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by dev on 12/03/17.
 */
@Entity
public class Imovel extends Anuncio {

    public Imovel () { super(); }

    public Imovel (String titulo, double preco) {
        super(titulo, preco);
    }

}
