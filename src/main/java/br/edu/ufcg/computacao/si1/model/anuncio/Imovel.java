package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

/**
 * Created by dev on 12/03/17.
 */
public class Imovel extends Anuncio {

    public Imovel () { super(); }

    public Imovel (String titulo, Date data, double preco) {
        super(titulo, data, preco);
    }

}
