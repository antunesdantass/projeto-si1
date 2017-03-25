package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.PessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findOne(id);
    }

    @Override
    public Usuario getByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Usuario usuario) {

        if (usuarioRepository.exists(usuario.getId())) {
            return usuarioRepository.save(usuario);
            }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
        }
    }

    @Override
    public boolean authenticate(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return (usuario != null && usuario.getSenha().equals(password));
    }
}
