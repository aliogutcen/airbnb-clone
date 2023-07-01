package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AuthenticationRequest;
import com.ogutcenali.dto.request.RegisterRequest;
import com.ogutcenali.dto.request.UpdateAuthRequest;
import com.ogutcenali.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @MutationMapping
    public Boolean register(@Argument @Valid RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return true;
    }

    @QueryMapping
    public String authenticate(@Argument @Valid AuthenticationRequest authenticationRequest) {
        return authService.authenticate(authenticationRequest);
    }

    public Boolean updateAuth(@Argument UpdateAuthRequest updateAuthRequest) {
        authService.updateAuth(updateAuthRequest);
        return true;

    }


}



