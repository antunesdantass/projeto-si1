package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Antunes Dantas.
 */
@Service
public class BuscaServiceImpl implements BuscaService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AnuncioRepository anuncioRepository;

    public Set<Anuncio> searchByUser(String email) throws UserNotFoundException {
        Usuario usuario = usuarioService.getByEmail(email);
        return usuario.getAnuncios();
    }

    public List<Anuncio> filterByDate(Date initialDate, Date finalDate) {
        return anuncioRepository.findByDataDeCriacaoBetween(initialDate, finalDate);
    }

    public List<Anuncio> getByTipo(String tipo) {
        return anuncioRepository.findByType(tipo);
    }

}
