package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import br.edu.ufcg.computacao.si1.service.FinancasServiceImpl;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by treinamento-huawei on 24/03/17.
 */
@CrossOrigin
@RequestMapping("ad-extreme/anuncio/comprar")
public class FinancasController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @Autowired
    private FinancasServiceImpl financasService;

    @RequestMapping(
            value = "/efetuarCompra",
            method = RequestMethod.PUT)
    public void efetuarCompra(@RequestBody Long idComprador, @RequestBody Long idAnuncio){
        Anuncio anuncio = anuncioService.getById(idAnuncio);

        Usuario comprador = usuarioService.getById(idComprador);
        Usuario vendedor = usuarioService.getById(anuncio.getIdAutor());

        financasService.efetuarCompra(anuncio, vendedor, comprador);
    }
}
