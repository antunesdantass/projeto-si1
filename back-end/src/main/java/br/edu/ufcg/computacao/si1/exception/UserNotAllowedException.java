package br.edu.ufcg.computacao.si1.exception;

/**
 * Created by dev on 25/03/17.
 */
public class UserNotAllowedException extends Exception {

    public UserNotAllowedException() {
        super("Apenas Pessoa Jurídica pode criar anúncio de emprego e serviço.");
    }

    public UserNotAllowedException(String message) {
        super(message);
    }
}
