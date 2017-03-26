package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.service.BuscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Antunes Dantas.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/ad-extreme/anuncio/pesquisa")
public class BuscaController {

    @Autowired
    BuscaService buscaService;

    @RequestMapping(
            value = "/usuario/{email}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Set<Anuncio>> getAnunciosByOwner(@RequestParam("email") String email) {
        try {
            return new ResponseEntity<Set<Anuncio>>(buscaService.searchByUser(email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<Set<Anuncio>>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(
            value = "/data/{inicio}/{fim}",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Anuncio>> filterByDate(@RequestParam("inicio") Date dataInicial,
                                                      @RequestParam("fim") Date dataFinal) {
        List<Anuncio> resultado =  buscaService.filterByDate(dataInicial, dataFinal);
        return new ResponseEntity<List<Anuncio>>(resultado, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/tipo/{tipo}",
            method = RequestMethod.GET
    )
    public List<Anuncio> getByTipo(@RequestParam("tipo") String tipo) {
        return buscaService.getByTipo(tipo);
    }

}
