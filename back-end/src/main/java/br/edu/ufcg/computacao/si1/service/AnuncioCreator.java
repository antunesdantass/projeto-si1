package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotAllowedExcepetion;
import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

/**
 * Created by Antunes Dantas.
 */
public interface AnuncioCreator {

    public Anuncio create(Anuncio anuncio, String token) throws UserNotAllowedExcepetion, UserNotFoundException;

}
