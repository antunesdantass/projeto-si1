package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adson_silva on 24/03/17.
 */
@Service
public class FinancasServiceImpl implements FinancasService {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @Override
    public void efetuarCompra(Long idComprador, Long idAnuncio) {
        Anuncio anuncio = anuncioService.getById(idAnuncio);

        Usuario comprador = usuarioService.getById(idComprador);
        Usuario vendedor = anuncio.getUsuario();

        comprador.comprar(anuncio.getPreco());
        vendedor.vender(anuncio.getPreco());

        vendedor.getAnuncios().remove(anuncio);
        anuncioService.delete(anuncio.getId());
        usuarioService.update(vendedor);
    }
}
