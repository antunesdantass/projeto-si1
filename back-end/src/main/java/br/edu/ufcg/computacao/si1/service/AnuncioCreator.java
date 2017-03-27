package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotAllowedException;
import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;

/**
 * Created by Antunes Dantas.
 */
public interface AnuncioCreator {

    public Anuncio create(Anuncio anuncio, String token) throws UserNotAllowedException, UserNotFoundException;

}
