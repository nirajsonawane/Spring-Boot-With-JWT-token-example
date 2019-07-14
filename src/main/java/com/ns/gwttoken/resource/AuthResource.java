package com.ns.gwttoken.resource;

import com.ns.gwttoken.service.JWTTokenProvider;
import com.ns.gwttoken.model.JwtAuthenticationResponse;
import com.ns.gwttoken.model.UserPrincipal;
import com.ns.gwttoken.model.AuthenticateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@Slf4j
public class AuthResource {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;


    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
        String token =jwtTokenProvider.generateToken((UserPrincipal)authentication.getPrincipal());
        log.info("Token Created {}",token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


}
