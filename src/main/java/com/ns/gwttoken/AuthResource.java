package com.ns.gwttoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthResource {


    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public void authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
        System.out.println(authenticateRequest.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()
                    )

            );
            System.out.println(authentication.isAuthenticated());
            System.out.println(authentication.getAuthorities());
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
        }


    }


}
