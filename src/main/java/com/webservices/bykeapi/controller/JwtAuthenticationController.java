package com.webservices.bykeapi.controller;

import com.webservices.bykeapi.config.JwtTokenUtil;
import com.webservices.bykeapi.domain.JwtResponse;
import com.webservices.bykeapi.domain.User;
import com.webservices.bykeapi.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    // on initialise
    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }
    // auhentification  qui va généré un jeton
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user)
            throws Exception {
        try {
            // On contrôle l'utilisateur
            UserDetails userDetails= appelAuthentication(user.getUsername(), user.getPassword());
            // on récupère les informations
            // nouvel accès à la base de données
            //final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getNomUtil());
            // On génère le jeton
            final String token = jwtTokenUtil.generateToken(userDetails);
            // on retourne le jeton dans un flux json
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Demande d'authentification à l'aide de l'objet instancié précédemment
    // La méthode authenticate() appellera la méthode loadUserByUsername() de la classe UserDetailsServiceImpl
    // L'objet autentication contiendra l'objet userDetails dans la propriété principal
    private UserDetails appelAuthentication(String username, String password) throws Exception {

        try {
            Authentication  authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return (UserDetails) authentication.getPrincipal();
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
