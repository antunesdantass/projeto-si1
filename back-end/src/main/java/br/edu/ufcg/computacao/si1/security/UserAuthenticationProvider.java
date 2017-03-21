package br.edu.ufcg.computacao.si1.security;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    private final AuthenticationService authenticationService;

    @Autowired
    public UserAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            try {
                Usuario usuario = authenticationService.getUserFromToken((String) authentication.getCredentials());
                return new AuthenticatedUser(usuario, (String) authentication.getCredentials());
            } catch (Exception e) {
                return null;
            }

    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (AuthenticatedUser.class.isAssignableFrom(authentication));
    }
}
