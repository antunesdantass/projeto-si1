package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    @Query("SELECT u FROM Usuario u WHERE u.email = ?#{[0]}")
    Usuario findByEmail(String email);

}
