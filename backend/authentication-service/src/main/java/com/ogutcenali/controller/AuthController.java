package com.ogutcenali.controller;

import com.ogutcenali.dto.request.AuthenticationRequest;
import com.ogutcenali.dto.request.RegisterRequest;
import com.ogutcenali.model.Auth;
import com.ogutcenali.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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

    @QueryMapping
    List<Auth> getAllAuth(){
        return authService.getAllAuth();
    }
}

