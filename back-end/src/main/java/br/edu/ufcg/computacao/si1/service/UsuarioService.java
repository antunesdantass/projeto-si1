package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import java.util.List;
public interface UsuarioService {

    Usuario create(Usuario usuario);

    Usuario getById(Long id);

    Usuario getByEmail(String email) throws UserNotFoundException;

    List<Usuario> getAll();

    Usuario update(Usuario usuario);

    void delete(Long id);

    boolean authenticate(String email, String password);

}
