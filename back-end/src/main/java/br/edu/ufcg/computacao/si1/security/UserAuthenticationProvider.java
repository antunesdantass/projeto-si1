package br.edu.ufcg.computacao.si1.security;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class UserAuthenticationProvider implements AuthenticationProvider, Serializable {

    private final AuthenticationService authenticationService;

    @Autowired
    public UserAuthenticationProvider(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            try {
                Usuario usuario = authenticationService.getUserFromToken((String) authentication.getPrincipal());
                return new UsernamePasswordAuthenticationToken(usuario.getEmail(), (String) authentication.getCredentials());
            } catch (Exception e) {
                return null;
            }

    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return true;
        //return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
