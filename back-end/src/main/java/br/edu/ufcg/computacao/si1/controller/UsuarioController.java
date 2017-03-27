package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by adson_silva on 12/03/17.
 */
@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;


    @RequestMapping(
            value = "ad-extreme/cadastrar/usuario",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @RequestMapping(value = "ad-extreme/usuario/id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findByID(@PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @RequestMapping(
            value = "ad-extreme/usuario/email/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> findByEmail(@PathVariable("email") String email){
        try {
            return new ResponseEntity<Usuario>(usuarioService.getByEmail(email), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(
            value = "ad-extreme/usuario",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @RequestMapping(
            value = "ad-extreme/usuario/id/{id}",
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
            value="ad-extreme/usuario/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
    }
}
