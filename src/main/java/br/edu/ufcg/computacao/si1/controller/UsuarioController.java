package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by adson_silva on 12/03/17.
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public Usuario criarUsuario(@RequestBody Usuario usuario){

        return usuarioService.create(usuario);
    }

    @RequestMapping(value = "/criar/mock", method = RequestMethod.GET)
    public Usuario criarUsuarioMock(){
        return usuarioService.createMock();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Usuario findByID(@PathVariable("id") Long id){
        return usuarioService.getById(id);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Usuario findByEmail(@PathVariable("email") String email){
        return usuarioService.getByEmail(email);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id) {
        return usuarioService.delete(id);
    }
}
