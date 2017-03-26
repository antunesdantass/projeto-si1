package br.edu.ufcg.computacao.si1.exception;

/**
 * Created by dev on 25/03/17.
 */
public class UserNotAllowedExcepetion extends Exception {

    public UserNotAllowedExcepetion() {
        super("Apenas Pessoa Jurídica pode criar anúncio de emprego.");
    }

    public UserNotAllowedExcepetion(String message) {
        super(message);
    }
}
