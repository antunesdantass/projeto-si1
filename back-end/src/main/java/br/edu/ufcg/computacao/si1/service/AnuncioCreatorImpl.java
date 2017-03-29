package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotAllowedException;
import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.Emprego;
import br.edu.ufcg.computacao.si1.model.anuncio.Servico;
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
    UsuarioService usuarioService;

    @Autowired
    AnuncioRepository anuncioRepository;

    public Anuncio create(Anuncio anuncio, String token) throws UserNotAllowedException, UserNotFoundException {
        Usuario usuario = jwtService.getUsuario(token);
        if (anuncio instanceof Emprego || anuncio instanceof Servico) {
            if (usuario instanceof PessoaJuridica) {
                anuncio.setUsuario(usuario);
                usuario.addAnuncio(anuncio);
                return anuncioRepository.save(anuncio);
            } else {
                throw new UserNotAllowedException();
            }
        } else {
            anuncio.setUsuario(usuario);
            usuario.addAnuncio(anuncio);
            return anuncioRepository.save(anuncio);
        }
    }

}
