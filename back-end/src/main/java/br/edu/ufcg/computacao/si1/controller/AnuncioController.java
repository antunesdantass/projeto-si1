package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.exception.UserNotAllowedException;
import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.service.AnuncioCreator;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

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
        try {
            Anuncio novoAnuncio = anuncioCreator.create(anuncio, token);
            return new ResponseEntity<Anuncio>(anuncio, HttpStatus.CREATED);
        } catch (UserNotAllowedException e) {
            return new ResponseEntity<Anuncio>(HttpStatus.FORBIDDEN);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<Anuncio>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Anuncio> update(@PathVariable("id") Long id, @RequestBody Anuncio anuncio) {
        if (id == anuncio.getId()) {
            return new ResponseEntity<Anuncio>(anuncioService.update(anuncio), HttpStatus.OK);
        } else {
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (anuncioService.getById(id) != null) {
            anuncioService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
