package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.exception.UserNotFoundException;
import br.edu.ufcg.computacao.si1.model.usuario.JwtUser;
import br.edu.ufcg.computacao.si1.model.usuario.LoggedUser;
import br.edu.ufcg.computacao.si1.model.usuario.LoginUser;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.JwtService;
import br.edu.ufcg.computacao.si1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Antunes Dantas on 22/03/17.
 */

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtService jwtService;

    @PostMapping
    public ResponseEntity<LoggedUser> login(@RequestBody LoginUser loginData) {
        try {
            Usuario usuario = usuarioService.getByEmail(loginData.getEmail());
            if (usuarioService.authenticate(loginData.getEmail(), loginData.getPassword())) {
                JwtUser jwtUser = new JwtUser(loginData.getEmail(), loginData.getPassword());
                String token = jwtService.getToken(jwtUser);
                return new ResponseEntity<LoggedUser>(new LoggedUser(usuario, token), HttpStatus.OK);
            } else {
                return new ResponseEntity<LoggedUser>(HttpStatus.UNAUTHORIZED);
            }
        } catch (UserNotFoundException e) {
            return new ResponseEntity<LoggedUser>(HttpStatus.NOT_FOUND);
        }
    }

}
