package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by adson_silva on 12/03/17.
 */
@CrossOrigin
@RequestMapping("ad-extreme/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private AnuncioServiceImpl anuncioService;


    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @RequestMapping(value = "id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findByID(@PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @RequestMapping(
            value = "email/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findByEmail(@PathVariable("email") String email){
        return usuarioService.getByEmail(email);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        if (id == usuario.getId()) {
            return usuarioService.update(usuario);
        } else {
            return null;
        }
    }

    @RequestMapping(
            value="/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
    }

    @RequestMapping(
            value = "/efetuarCompra",
            method = RequestMethod.PUT)
    public void efetuarCompra(@RequestBody Long idComprador,
                              @RequestBody Long idAnuncio){
        Anuncio anuncio = anuncioService.getById(idAnuncio);

        Usuario comprador = usuarioService.getById(idComprador);
        Usuario vendedor = usuarioService.getById(anuncio.getIdAutor());

        comprador.comprar(anuncio.getPreco());
        vendedor.vender(anuncio.getPreco());

    }
}
