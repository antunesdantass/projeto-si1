package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.Emprego;
import br.edu.ufcg.computacao.si1.model.anuncio.Imovel;
import br.edu.ufcg.computacao.si1.model.anuncio.Movel;
import br.edu.ufcg.computacao.si1.service.AnuncioCreator;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RequestMapping(value = "/ad-extreme/anuncio")
@RestController
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @Autowired
    private AnuncioCreator anuncioCreator;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Anuncio>> getAll() {
       return new ResponseEntity<List<Anuncio>>(anuncioService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> findOne(@PathVariable("id") Long id) {
        Anuncio anuncio = anuncioService.getById(id);
        if (anuncio != null) {
            return new ResponseEntity<Anuncio>(anuncio, HttpStatus.OK);
        } else {
            return new ResponseEntity<Anuncio>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Anuncio> create(@RequestBody Anuncio anuncio, @RequestHeader(value = "x-auth-token") String token) {
        Anuncio novoAnuncio = anuncioCreator.create(anuncio, token);
        return new ResponseEntity<Anuncio>(anuncio, HttpStatus.CREATED);
    }

}
