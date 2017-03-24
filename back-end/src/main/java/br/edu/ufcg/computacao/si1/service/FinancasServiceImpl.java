package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by treinamento-huawei on 24/03/17.
 */
public class FinancasServiceImpl implements FinancasService {


    @Override
    public void efetuarCompra(Anuncio anuncio, Usuario vendedor, Usuario comprador) {
            comprador.comprar(anuncio.getPreco());
            vendedor.vender(anuncio.getPreco());
    }
}
