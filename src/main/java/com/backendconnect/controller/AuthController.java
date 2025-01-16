package com.backendconnect.controller;

import com.backendconnect.infra.security.DataTokenJWT;
import com.backendconnect.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendconnect.domain.user.AuthData;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid AuthData data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.generateToken((User) authentication).getPrincipal();
        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

//    public AuthenticationManager getAuthenticationManager() {
//        return authenticationManager;
//    }
}
