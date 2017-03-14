package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    @Query("SELECT a FROM Anuncio a WHERE a.dtype = Emprego")
    List<Anuncio> findAllOfEmprego();

    @Query("SELECT a FROM Anuncio a WHERE a.dtype = Imovel")
    List<Anuncio> findAllOfImovel();

    @Query("SELECT a FROM Anuncio a WHERE a.dtype = Movel")
    List<Anuncio> findAllOfMovel();

}
