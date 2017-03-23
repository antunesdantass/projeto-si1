package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.usuario.JwtUser;
import br.edu.ufcg.computacao.si1.model.usuario.LoginUser;
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
    public ResponseEntity<String> login(@RequestBody LoginUser usuario) {
        if (usuarioService.authenticate(usuario.getEmail(), usuario.getPassword())) {
            JwtUser jwtUser = new JwtUser(usuario.getEmail(), usuario.getPassword());
            String token = jwtService.getToken(jwtUser);
            return new ResponseEntity<String>(token, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
    }

}
