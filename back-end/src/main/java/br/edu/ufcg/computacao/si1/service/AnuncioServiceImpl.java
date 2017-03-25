package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.Emprego;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Antunes Dantas.
 */
@Service
public class AnuncioServiceImpl implements AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public AnuncioServiceImpl(AnuncioRepository anuncioRepository, UsuarioService usuarioService) {
        this.anuncioRepository = anuncioRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public Anuncio create(Anuncio anuncio, String token) {
//        if (anuncio instanceof Emprego) {
//            Usuario usuario = usuarioService.get
//            if ()
//        }
        return null;
    }

    @Override
    public Anuncio getById(Long id) {
        return anuncioRepository.findOne(id);
    }

    @Override
    public List<Anuncio> getByTipo(String tipo) {
        return anuncioRepository.findByType(tipo);
    }

    @Override
    public List<Anuncio> findAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public Anuncio update(Anuncio anuncio) {

        if (anuncioRepository.exists(anuncio.getId())) {
           return anuncioRepository.save(anuncio);
        }
        return null;
    }

    @Override
    public void delete(Long id) {

        if (anuncioRepository.exists(id)) {
            anuncioRepository.delete(id);
        }
    }
}
