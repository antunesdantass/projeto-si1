package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Antunes Dantas.
 */
public interface BuscaService {

    Set<Anuncio> searchByUser(String email) throws UserNotFoundException;

    List<Anuncio> filterByDate(Date inicialDate, Date finalDate);

}
