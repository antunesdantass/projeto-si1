package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Usuario criarUsuario(@PathVariable String nome, @PathVariable String email, @PathVariable String senha,
                                @PathVariable String role, @PathVariable String documento){

        return usuarioService.create(nome, email, senha, role, documento);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Usuario> findByID(@PathVariable Long id){
        return usuarioService.getById(id);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Optional<Usuario> findByEmail(@PathVariable String email){
        return usuarioService.getByEmail(email);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public boolean update(Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public boolean delete(Long id) {
        return usuarioService.delete(id);
    }
}
