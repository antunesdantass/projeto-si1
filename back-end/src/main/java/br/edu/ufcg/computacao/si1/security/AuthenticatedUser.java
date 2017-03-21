package br.edu.ufcg.computacao.si1.security;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Antunes Dantas on 21/03/17.
 */
public class AuthenticatedUser implements Authentication {

    private String token;
    private Usuario usuario;

    public AuthenticatedUser(String token) {
        this.token = token;
    }

    public AuthenticatedUser(Usuario usuario) {
        this.usuario = usuario;
    }

    public AuthenticatedUser(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }

    public String getToken() {
        return this.token;
    }


    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return this.usuario != null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }

    public Usuario getUsuarioInfo() {
        return this.usuario;
    }

}
