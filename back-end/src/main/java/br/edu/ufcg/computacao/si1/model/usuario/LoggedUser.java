package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Created by Antunes Dantas on 25/03/17.
 */
public class LoggedUser {

    private String email;
    private String token;

    public LoggedUser(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public LoggedUser() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
