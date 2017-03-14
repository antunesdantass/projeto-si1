package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@Service
public class AnuncioServiceImpl implements AnuncioService {

    private AnuncioRepository anuncioRepository;

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    @Override
    public Anuncio create(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    @Override
    public Anuncio getById(Long id) {
        return anuncioRepository.findOne(id);
    }

    @Override
    public List<Anuncio> getByTipo(String tipo) {
        if (tipo.equalsIgnoreCase("emprego")) {
            return anuncioRepository.findAllOfEmprego();
        } else if (tipo.equalsIgnoreCase("movel")) {
            return anuncioRepository.findAllOfMovel();
        } else if (tipo.equalsIgnoreCase("imovel")) {
            return anuncioRepository.findAllOfImovel();
        } else {
            return null;
        }
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
