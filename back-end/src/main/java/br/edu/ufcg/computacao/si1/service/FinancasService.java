package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

/**
 * Created by treinamento-huawei on 24/03/17.
 */
public interface FinancasService {

    void efetuarCompra(Long idComprador, Long idAnuncio);
}
