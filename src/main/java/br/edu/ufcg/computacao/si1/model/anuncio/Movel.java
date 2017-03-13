package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Antunes Dantas on 12/03/17.
 */

@Entity
public class Movel extends Anuncio {

    public Movel() { super(); }

    public Movel(String titulo, Date data, double preco) {
        super(titulo, data, preco);
    }

}
