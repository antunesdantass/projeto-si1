package br.edu.ufcg.computacao.si1.exception;

/**
 * Created by dev on 25/03/17.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
