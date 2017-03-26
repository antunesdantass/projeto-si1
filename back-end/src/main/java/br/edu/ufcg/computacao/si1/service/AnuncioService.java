package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
public interface AnuncioService {

    Anuncio getById(Long id);

    List<Anuncio> findAll();

    Anuncio update(Anuncio anuncio);

    void delete(Long id);

}
