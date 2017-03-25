package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import br.edu.ufcg.computacao.si1.service.FinancasServiceImpl;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by adson_silva on 24/03/17.
 */
@CrossOrigin
@RequestMapping("ad-extreme/anuncio/")
public class FinancasController {

    @Autowired
    private FinancasServiceImpl financasService;

    @RequestMapping(
            value = "/{idAnuncio}/comprar",
            method = RequestMethod.PUT)
    public void efetuarCompra(@RequestBody Long idComprador, @PathVariable("idAnuncio") Long idAnuncio){

        financasService.efetuarCompra(idComprador, idAnuncio);
    }
}
