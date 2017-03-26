package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotAllowedExcepetion;
import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.Emprego;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Antunes Dantas.
 */

@Service
public class AnuncioCreatorImpl implements AnuncioCreator {

    @Autowired
    JwtService jwtService;

    @Autowired
    AnuncioRepository anuncioRepository;

    public Anuncio create(Anuncio anuncio, String token) throws UserNotAllowedExcepetion, UserNotFoundException {
        Usuario usuario = jwtService.getUsuario(token);
        if (anuncio instanceof Emprego) {
            if (usuario instanceof PessoaJuridica) {
                anuncio.setUsuario(usuario);
                return anuncioRepository.save(anuncio);
            } else {
                throw new UserNotAllowedExcepetion();
            }
        } else {
            anuncio.setUsuario(usuario);
            return anuncioRepository.save(anuncio);
        }
    }

}
