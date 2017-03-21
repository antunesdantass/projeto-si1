package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class AuthenticationService {

    private static final String ISSUER = "ad-extreme";
    private UsuarioService usuarioService;
    private final String secretKey = "si1-ad-extreme";

    @Autowired
    public AuthenticationService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario authenticate(UserCredentials credentials) {
        Usuario user = usuarioService.getByEmail(credentials.getUsername());

        if (user != null && user.getSenha().equals((credentials.getPassword()))) {
            return user;
        }
        return null;
    }

    public Usuario getUserFromToken(String token) throws IOException, URISyntaxException {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

        Usuario usuario = usuarioService.getByEmail(claims.getBody().getSubject().toString());

        return usuario;
    }

}