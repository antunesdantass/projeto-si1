package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Created by Antunes Dantas on 25/03/17.
 */
public class LoggedUser {

    private Usuario usuario;
    private String token;

    public LoggedUser(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public LoggedUser() {}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
