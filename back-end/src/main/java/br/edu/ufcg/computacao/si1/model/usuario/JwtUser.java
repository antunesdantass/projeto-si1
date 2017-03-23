package br.edu.ufcg.computacao.si1.model.usuario;

/**
 * Created by Antunes Dantas on 20/03/17.
 */
public class JwtUser {

    private String email;
    private String role;

    public JwtUser(String email, String role) {
        this.email = email;
        this.role = role;
    }

    public JwtUser(String email) {
        this.email = email;
    }

    public JwtUser() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
