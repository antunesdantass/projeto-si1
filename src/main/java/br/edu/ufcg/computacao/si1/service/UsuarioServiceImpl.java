package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.PessoaFísica;
import br.edu.ufcg.computacao.si1.model.usuario.PessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario create(String nome, String email, String senha, String role, String documento) {

        Usuario usuario=null;

        switch (role){
            case "fisica":
                usuario = new PessoaFísica(nome, email, senha, documento);
                break;

            case "juridica":
                usuario = new PessoaJuridica(nome, email, senha, documento);

                //new BCryptPasswordEncoder().encode(usuarioForm.getSenha()), "COMPANY");
                usuario.setRole("COMPANY");
                break;
        }

        System.out.println(usuario + "estah sendo criado");
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return Optional.ofNullable(usuarioRepository.findOne(id));
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        System.out.println(email + "estah sendo retornado");
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }

    @Override
    public Collection<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean update(Usuario usuario) {
        System.out.println(usuario + "estah sendo atualizado");

        if (usuarioRepository.exists(usuario.getId())) {
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
            return true;
        }
        return false;
    }
}
